package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagemProdutoDto {

    private Long id;
    private String nome;

    public ImagemProdutoDto(Long id, String nome, byte[] imagem) {
        this.id = id;
        this.nome = nome;
    }
}
