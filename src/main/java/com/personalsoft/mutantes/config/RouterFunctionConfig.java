package com.personalsoft.mutantes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.personalsoft.mutantes.service.MutantServiceImpl;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

import co.com.personalsoft.reactivemongoapp.vendors.ProductoHandler;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RouterFunctionConfig {
	@Bean
	public RouterFunction<ServerResponse> routes(MutantServiceImpl handler){
		return null;
	}

}
