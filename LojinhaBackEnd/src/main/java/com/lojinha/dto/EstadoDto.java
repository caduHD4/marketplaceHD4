package com.lojinha.dto;

import java.util.Date;

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
    public void setDataCriacao(Date date) {
    }
}
