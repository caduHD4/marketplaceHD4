package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PessoaDto {
    private Long id;
    private String nome;
    private String CPF;
    private String email;
    private String senha;
    private String endereco;
    private String CEP;
}
