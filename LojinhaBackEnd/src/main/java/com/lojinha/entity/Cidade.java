package com.lojinha.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column()
    private String nome;

    @Column()
    private Date dataCriacao;

    @Column()
    private Date dataAtualizacao;

    @ManyToOne(optional = false)
    private Estado estado;
    
}
