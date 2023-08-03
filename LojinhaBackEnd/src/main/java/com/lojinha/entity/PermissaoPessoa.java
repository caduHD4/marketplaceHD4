package com.lojinha.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "permissao_pessoa")
@Data

public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;
    private Date dataCriacao;
    private Date dataAtualizacao;
    
}
