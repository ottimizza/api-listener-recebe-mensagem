package br.com.totali.listenerrecebemensagem.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totali.listenerrecebemensagem.clients.MiddlewareClient;
import br.com.totali.listenerrecebemensagem.domain.commands.KafkaPayloadMessage;

@Service
public class RecebeMensagemService {
    
    @Autowired
    MiddlewareClient middlewareClient;

    public String recebeMensagem(String mensagem) throws Exception {
        KafkaPayloadMessage payload = new ObjectMapper().readValue(mensagem, KafkaPayloadMessage.class);
        String text = new ObjectMapper().readValue(payload.getMessage(), String.class);

        String token = middlewareClient.getToken("{    \"VersaoLayout\": 2,    \"CodigoEmpresa\": 0,    \"UserOS\": \"pedro\",    \"DataSolicitacao\": \"14\\/09\\/2023 09:13:05\",    \"NomeMaquina\": \"PEDRO-PC\",    \"VersaoBase\": 250,    \"NomeSistema\": \"TestadorMiddlewareService\",    \"VersaoSistema\": \"1.0\",    \"TipoRetorno\": \"S\",    \"CNPJ\": \"04303719000152\",    \"IPMiddlewareServidor\": \"\",    \"PortaMiddlewareServidor\": 0}").getBody();
        System.out.println(token);
        return "Mensagem recebida!";
    }

}
