package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PessoaDto {
    Long id;
    String nome;
    String CPF;
    String email;
    String senha;
    String endereco;
    String CEP;
}
