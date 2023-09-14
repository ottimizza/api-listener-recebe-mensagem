package br.com.totali.listenerrecebemensagem.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totali.listenerrecebemensagem.clients.HttpMethodsClient;
import br.com.totali.listenerrecebemensagem.clients.MiddlewareClient;
import br.com.totali.listenerrecebemensagem.domain.commands.KafkaPayloadMessage;
import br.com.totali.listenerrecebemensagem.utils.AuthenticationUtils;

@Service
public class RecebeMensagemService {
    
    @Autowired
    private MiddlewareClient middlewareClient;

    private HttpMethodsClient methodsClient;

    public String recebeMensagem(String mensagem) throws Exception {
        AuthenticationUtils authenticationUtils = new AuthenticationUtils();
        KafkaPayloadMessage payload = new ObjectMapper().readValue(mensagem, KafkaPayloadMessage.class);
        String text = new ObjectMapper().readValue(payload.getMessage(), String.class);
        JSONObject object = new JSONObject(text);

        //GERANDO TOKEN PARA A AUTENTICACAO DENTRO DAS APLICACOES 
        String token = authenticationUtils.generateToken();
        //Envio de request para outras aplicacoes a partir de client ou urls recebidas do body

        //ENVIO A PARTIR DE UM AMBIENTE EM QUE A URL PODE VARIAR
        methodsClient.postMethod(object.optString("requestUrl"), 
                                 object.optString("requestBody"), 
                                 object.optString("webhookUrl"),
                                 token);

        //ENVIO A PARTIR DE UM AMBIENTE COM URL PADRAO
        middlewareClient.postObject(text, token);

        return "Mensagem recebida!";
    }

}
