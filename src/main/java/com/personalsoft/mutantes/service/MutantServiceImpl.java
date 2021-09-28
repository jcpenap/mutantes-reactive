package com.personalsoft.mutantes.service;

import com.personalsoft.mutantes.DnaRequest;
import com.personalsoft.mutantes.domain.DnaResult;
import com.personalsoft.mutantes.repositories.SecuencesDNARepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class MutantServiceImpl implements  MutantService {
	public final SecuencesDNARepository secuencesDNA;
    @Override
    public Mono<ServerResponse> isMutantArray(ServerRequest request) {
        Mono<DnaRequest> dnaRequestMono = request.bodyToMono(DnaRequest.class);
        return dnaRequestMono.map(isMutant)
        .zipWith(dnaRequestMono, (ismutante, adn) -> new DnaResult(ismutante, adn.getDna().toString())
        )
        .map(dnaresult -> {
        	secuencesDNA.save(dnaresult);
        	return dnaresult.isMutant();
        	}
        )
        .flatMap(validacionMutante -> ServerResponse
				.badRequest()
				.body(BodyInserters.fromValue(validacionMutante)));
    }
    
    Function<DnaRequest, Boolean> isMutant = r -> {
        String[] input = new String[r.getDna().size()];
        r.getDna().toArray(input);
        int repeatLength = 4;
        int maxStartRow = input.length - repeatLength;
        int maxStartColumn = input[0].length() - repeatLength;
        for (int i = 0; i <= maxStartRow; i++) {
            for (int j = 0; j <= maxStartColumn; j++) {
                boolean allMatch = true;
                char[] sequence = new char[repeatLength];
                sequence[0] = input[i].charAt(j);
                for (int diagonalCounter = 1; diagonalCounter < repeatLength && allMatch; diagonalCounter++) {
                    sequence[diagonalCounter] = input[i + diagonalCounter].charAt(j + diagonalCounter);
                    allMatch &= (sequence[0] == sequence[diagonalCounter]);
                }
                if (allMatch) {
                    return true;
                }
            }
        }
        return Boolean.FALSE;
    };
    

}
