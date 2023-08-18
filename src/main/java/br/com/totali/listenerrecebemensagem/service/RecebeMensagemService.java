package br.com.totali.listenerrecebemensagem.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totali.listenerrecebemensagem.domain.commands.KafkaPayloadMessage;

@Service
public class RecebeMensagemService {
    
    public String recebeMensagem(String mensagem) throws Exception {
        KafkaPayloadMessage payload = new ObjectMapper().readValue(mensagem, KafkaPayloadMessage.class);
        String text = new ObjectMapper().readValue(payload.getMessage(), String.class);
        JSONObject objeto = new JSONObject(text);

        if(objeto.has("produto"))
            System.out.println("é produto");
        else 
            System.out.println("nota");
        return "Mensagem recebida!";
    }

}
