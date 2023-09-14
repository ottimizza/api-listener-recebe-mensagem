package br.com.totali.listenerrecebemensagem.utils;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totali.listenerrecebemensagem.clients.MiddlewareClient;
import br.com.totali.listenerrecebemensagem.domain.dto.MiddlewareAuthentication;

public class AuthenticationUtils {

    @Autowired
    private MiddlewareClient middlewareClient;

    public String generateToken() throws Exception {
        // PEGRA USERNAME E PASSWORD DA AUTENTICACAO DE VARIAVEL DE AMBIENTE
        String authorization = Base64.getEncoder().encodeToString(("totall"+"112233").getBytes()); 
        MiddlewareAuthentication authentication = MiddlewareAuthentication.builder()
                .VersaoLayout(2)
                .CodigoEmpresa(0)
                .UserOS("pedro")
                .DataSolicitacao("14/09/2023 09:13:05")
                .NomeMaquina("PEDRO-PC")
                .VersaoBase(250)
                .NomeSistema("TestadorMiddlewareService")
                .VersaoSistema("1.0")
                .TipoRetorno("S")
                .CNPJ("04303719000152")
                .IPMiddlewareServidor("")
                .PortaMiddlewareServidor(0)
            .build();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(authentication));
        return middlewareClient.getToken(authentication, authorization).getBody();
    }

    
}
