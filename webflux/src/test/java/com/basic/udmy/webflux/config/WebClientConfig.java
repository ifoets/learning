package com.basic.udmy.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
		        .baseUrl("http://localhost:8080")
		        // this is basic authentication
		        // .defaultHeaders(e -> e.setBasicAuth("username", "password"))
		        // this filter is form ExchangeFilterFunction not to filter something
		        // .filter(this::generatingToken)
		        .filter(this::sessionToken)
		        .build();
	}

	// this for token type credentials
	private Mono<ClientResponse> generatingToken(ClientRequest request, ExchangeFunction next) {

		System.out.println("Generating Session Token...");

		ClientRequest clientRequest = ClientRequest.from(request)
		        .headers(e -> e.setBearerAuth("some-complx-string"))
		        .build();

		return next.exchange(clientRequest);
	}

	// attribute: this is for run time deciding authorisation required basic or
	// token type credentials

	private Mono<ClientResponse> sessionToken(ClientRequest request, ExchangeFunction next) {

		ClientRequest clientRequest = request.attribute("auth")
		        .map(e -> e.equals("basic") ? withBasicAuth(request) : withAuth(request))
		        .orElse(request);

		return next.exchange(clientRequest);
	}

	private ClientRequest withBasicAuth(ClientRequest clientRequest) {
		ClientRequest request = ClientRequest.from(clientRequest)
		        .headers(e -> e.setBasicAuth("username", "password"))
		        .build();
		return request;

	}

	private ClientRequest withAuth(ClientRequest clientRequest) {
		ClientRequest request = ClientRequest.from(clientRequest)
		        .headers(e -> e.setBearerAuth("session-token-generating-string"))
		        .build();
		return request;

	}
}
