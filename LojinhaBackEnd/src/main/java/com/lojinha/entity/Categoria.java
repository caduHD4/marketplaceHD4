package com.lojinha.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "categoria")
@Data

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private String nome;

    @Column()
    private Date dataCriacao = new Date();

    @Column()
    private Date dataAtualizacao = new Date();

}
