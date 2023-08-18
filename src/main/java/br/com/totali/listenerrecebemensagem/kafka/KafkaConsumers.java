package br.com.totali.listenerrecebemensagem.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.totali.listenerrecebemensagem.config.kafka.KafkaProperties;
import br.com.totali.listenerrecebemensagem.service.RecebeMensagemService;

@Component
public class KafkaConsumers {
    
    @Autowired
    private KafkaProperties kafkaProperties; 

    @Autowired
    private RecebeMensagemService service;

    @KafkaListener(topics = "#{kafkaProperties.getPrefix()} ",
                       groupId = "#{kafkaProperties.getPrefix()}envia-mensagem-group")
    public void recebeMensagem(@Payload String mensagem) throws Exception {
        try {
            service.recebeMensagem(mensagem);
        }
        catch(Exception ex){
            System.out.println("Erro service -> "+ex.getMessage());
        }
    }

}
