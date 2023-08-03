package com.lojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double precoCusto;
    private Double precoVenda;

}
