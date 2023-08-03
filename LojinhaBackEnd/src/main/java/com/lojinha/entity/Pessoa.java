package com.lojinha.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "O nome é obrigatório.")
    private String nome;

    @NotNull (message = "O CPF é obrigatório.")
    @org.hibernate.validator.constraints.br.CPF (message = "O CPF deve ser válido.")
    private String CPF;

    @Email(message = "O email deve ser válido.")
    private String email;

    @NotNull (message = "A senha é obrigatória.")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
    private String senha;

    private String endereco;

    @NotNull (message = "O CEP é obrigatório.")
    private String CEP;

    @NotNull (message = "A data de criação é obrigatória.")
    private Date dataCriacao;

    @NotNull (message = "A data de atualização é obrigatória.")
    private Date dataAtualizacao;
}