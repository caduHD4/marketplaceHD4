package com.lojinha.repository;

import com.lojinha.entity.CarrinhoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Long> {
}
