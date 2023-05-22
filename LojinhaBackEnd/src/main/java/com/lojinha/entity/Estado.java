package com.lojinha.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private String nome;

    @Column()
    private String sigla;

    @Column()
    private Date dataCriacao = new Date();

    @Column()
    private Date dataAtualizacao = new Date();
}
