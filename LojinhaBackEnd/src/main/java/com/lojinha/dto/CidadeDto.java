package com.lojinha.dto;

import com.lojinha.entity.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CidadeDto {
    Long id;
    String nome;
    Estado estado;
    Long estadoId;

     public CidadeDto(Long id, String nome, Long estadoId) {
        this.id = id;
        this.nome = nome;
        this.estadoId = estadoId;
    }
}
