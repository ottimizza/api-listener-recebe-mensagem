package br.com.totali.listenerrecebemensagem.clients;

import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "middleware", url = "http://monitor.datainfo.inf.br:8080")
public interface MiddlewareClient {
 
    @PostMapping(value = "/datasnap/rest/TConexaoAPI/ConectaMiddleware")
    public ResponseEntity<String> getToken(@RequestBody String objeto);

}
