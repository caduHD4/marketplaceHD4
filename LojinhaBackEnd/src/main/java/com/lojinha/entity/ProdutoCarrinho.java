package com.lojinha.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "produto_carrinho")
@Data

public class ProdutoCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private Double valor;

    @Column()
    private Double quantidade;

    @Column()
    private String observacao;

    @Column()
    private Date dataCriacao = new Date();

    @Column()
    private Date dataAtualizacao = new Date();

}
