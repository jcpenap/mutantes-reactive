package com.personalsoft.mutantes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DnaRequest {
    List<String> dna = new ArrayList<>();
}
