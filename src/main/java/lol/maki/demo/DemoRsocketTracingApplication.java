package lol.maki.demo;

import brave.Span.Kind;
import brave.Tracing;
import io.rsocket.metadata.WellKnownMimeType;

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
			interceptorRegistry.forSocketAcceptor(socketAcceptor -> (setup, sendingSocket) -> socketAcceptor
					.accept(setup, sendingSocket)
					.map(rSocket -> new TracingRSocketProxy(rSocket, WellKnownMimeType.fromString(setup.metadataMimeType()), tracing, Kind.SERVER)));
		});
	}
}
