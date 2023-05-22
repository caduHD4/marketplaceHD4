package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoDto {
    private Long id;
    private String nome;
    private String sigla;
}
