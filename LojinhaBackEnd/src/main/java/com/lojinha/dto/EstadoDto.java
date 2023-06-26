package com.lojinha.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoDto {
    Long id;
    String nome;
    String sigla;
}
