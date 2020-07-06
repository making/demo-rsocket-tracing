package lol.maki.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DemoController {
	private final Logger log = LoggerFactory.getLogger(DemoController.class);

	@MessageMapping("fnf")
	public Mono<Void> fireAndForget() {
		log.info("fire-and-forget");
		return Mono.empty().log("fire-and-forget").then();
	}

	@MessageMapping("rr")
	public Mono<String> requestResponse() {
		log.info("request-response");
		return Mono.just("Hello World!").log("request-response");
	}

	@MessageMapping("rs")
	public Flux<String> requestStream() {
		log.info("request-stream");
		return Flux.just("H", "e", "l", "l", "o", " ", "W", "o", "r", "l", "d", "!").log("request-stream");
	}

	@MessageMapping("rc")
	public Flux<String> requestChannel(Flux<String> words) {
		log.info("request-channel");
		return words.map(x -> String.format("Hello %s!", x)).log("request-channel");
	}
}
