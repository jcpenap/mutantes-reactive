package com.personalsoft.mutantes.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.personalsoft.mutantes.domain.DnaResult;

import reactor.core.publisher.Mono;

@Repository
public interface SecuencesDNARepository extends ReactiveMongoRepository<DnaResult, String>{
	Mono<DnaResult> findByName(Long name);
	

}