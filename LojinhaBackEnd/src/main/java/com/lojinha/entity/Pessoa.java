package com.lojinha.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CPF;
    private String email;
    private String senha;
    private String endereco;
    private String CEP;
    private Date dataCriacao;
    private Date dataAtualizacao;
}