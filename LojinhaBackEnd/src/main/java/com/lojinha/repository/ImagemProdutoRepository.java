package com.lojinha.repository;

import com.lojinha.entity.ImagemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
}
