package com.personalsoft.mutantes.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dna_result")
@Getter
@Setter
public class DnaResult {
    private Long id;
    private boolean isMutant;
	private String sequence;
	
	public DnaResult(boolean isMutant, String sequence) {
		super();
		this.isMutant = isMutant;
		this.sequence = sequence;
	}
}