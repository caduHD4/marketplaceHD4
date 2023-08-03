package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoCarrinhoDto {

    private Long id;
    private Double valor;
    private Double quantidade;
    private String observacao;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
