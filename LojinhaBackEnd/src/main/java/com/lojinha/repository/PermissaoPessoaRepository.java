package com.lojinha.repository;

import com.lojinha.entity.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {
}
