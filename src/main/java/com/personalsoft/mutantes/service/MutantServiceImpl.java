package com.personalsoft.mutantes.service;

import com.personalsoft.mutantes.DnaRequest;
import com.personalsoft.mutantes.domain.DnaResult;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@NoArgsConstructor
public class MutantServiceImpl implements  MutantService {
    @Override
    public Boolean isMutant(ServerRequest request) {
        Mono<DnaRequest> secuenceMono = request.bodyToMono(DnaRequest.class);

        Mono<DnaRequest> dnaRequestMono = request.bodyToMono(DnaRequest.class);
        dnaRequestMono.map(r -> {
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
        }).subscribe();


        return null;
    }


}
