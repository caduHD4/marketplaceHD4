package com.lojinha.repository;

import com.lojinha.entity.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {
}
