package lol.maki.demo;

import reactor.core.publisher.Hooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRsocketTracingApplication {

	public static void main(String[] args) {
		Hooks.onErrorDropped(e -> {}); // https://github.com/rsocket/rsocket-java/issues/1018
		SpringApplication.run(DemoRsocketTracingApplication.class, args);
	}
}
