package lol.maki.demo;

import brave.Span.Kind;
import brave.Tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.server.RSocketServerCustomizer;
import org.springframework.cloud.sleuth.instrument.reactor.TracingRSocketProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoRsocketTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRsocketTracingApplication.class, args);
	}

	@Bean
	public RSocketServerCustomizer serverRSocketFactoryProcessor(Tracing tracing) {
		return server -> server.interceptors(interceptorRegistry -> {
			interceptorRegistry.forResponder(rSocket -> {
				return new TracingRSocketProxy(rSocket, tracing, Kind.SERVER);
			});
		});
	}
}
