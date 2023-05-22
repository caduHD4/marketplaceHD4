package com.lojinha.repository;

import com.lojinha.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNomeContainingIgnoreCase(String nome);
}
