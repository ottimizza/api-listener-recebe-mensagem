package br.com.totali.listenerrecebemensagem.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MiddlewareAuthentication implements Serializable {
    
    @JsonProperty(value = "VersaoLayout")
    private int VersaoLayout;
    
    @JsonProperty(value = "CodigoEmpresa")
    private int CodigoEmpresa;
    
    @JsonProperty(value = "UserOS")
    private String UserOS;
    
    @JsonProperty(value = "DataSolicitacao")
    private String DataSolicitacao;
    
    @JsonProperty(value = "NomeMaquina")
    private String NomeMaquina;
    
    @JsonProperty(value = "VersaoBase")
    private int VersaoBase;
    
    @JsonProperty(value = "NomeSistema")
    private String NomeSistema;
    
    @JsonProperty(value = "VersaoSistema")
    private String VersaoSistema;
    
    @JsonProperty(value = "TipoRetorno")
    private String TipoRetorno;
    
    @JsonProperty(value = "CNPJ")
    private String CNPJ;
    
    @JsonProperty(value = "IPMiddlewareServidor")
    private String IPMiddlewareServidor;
    
    @JsonProperty(value = "PortaMiddlewareServidor")
    private int PortaMiddlewareServidor;

}
