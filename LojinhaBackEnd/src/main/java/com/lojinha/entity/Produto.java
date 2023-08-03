package com.lojinha.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column()
    private String descricaoCurta;

    @Column()
    private String descricaoDetalhada;

    @Column()
    private Double precoCusto;

    @Column()
    private Double precoVenda;

    @Column()
    private Date dataCriacao = new Date();

    @Column()
    private Date dataAtualizacao = new Date();

}
