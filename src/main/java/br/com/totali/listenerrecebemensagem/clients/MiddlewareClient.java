package br.com.totali.listenerrecebemensagem.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.totali.listenerrecebemensagem.domain.dto.MiddlewareAuthentication;

@FeignClient(name = "middleware", url = "http://monitor.datainfo.inf.br:8080")
public interface MiddlewareClient {
 
    @PostMapping(value = "/datasnap/rest/TConexaoAPI/ConectaMiddleware", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getToken(@RequestBody MiddlewareAuthentication objeto, @RequestHeader("Authorization") String authorization);

    @PostMapping(value = "/post/object")
    public ResponseEntity<String> postObject(@RequestBody String object, @RequestHeader("Authorization") String authorization);

}
