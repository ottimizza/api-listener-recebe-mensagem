package br.com.totali.listenerrecebemensagem.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MiddlewareAuthentication implements Serializable {
    
    private int VersaoLayout;
    private int CodigoEmpresa;
    private String UserOS;
    private String DataSolicitacao;
    private String NomeMaquina;
    private int VersaoBase;
    private String NomeSistema;
    private String VersaoSistema;
    private String TipoRetorno;
    private String CNPJ;
    private String IPMiddlewareServidor;
    private int PortaMiddlewareServidor;

}
