package br.com.totali.listenerrecebemensagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ListenerRecebemensagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListenerRecebemensagemApplication.class, args);
	}

}
