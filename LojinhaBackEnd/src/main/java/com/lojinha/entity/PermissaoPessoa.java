package com.lojinha.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data

public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

    @Column()
    private Date dataCriacao;

    @Column()
    private Date dataAtualizacao;
    
}
