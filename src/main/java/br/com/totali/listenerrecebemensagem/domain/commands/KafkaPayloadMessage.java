package br.com.totali.listenerrecebemensagem.domain.commands;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class KafkaPayloadMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private KafkaPayloadPrincipal principal;

    private String message;

}