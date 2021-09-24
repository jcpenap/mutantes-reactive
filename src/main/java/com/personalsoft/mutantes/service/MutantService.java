package com.personalsoft.mutantes.service;

import org.springframework.web.reactive.function.server.ServerRequest;

public interface MutantService {

    Boolean isMutant(ServerRequest request);

}
