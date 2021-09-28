package com.personalsoft.mutantes.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface MutantService {

	Mono<ServerResponse>  isMutantArray(ServerRequest request);

}
