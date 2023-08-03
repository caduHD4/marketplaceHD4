package com.lojinha.service;

import com.lojinha.entity.ProdutoCarrinho;
import com.lojinha.repository.ProdutoCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoCarrinhoService {

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

    public List<ProdutoCarrinho> buscarTodos() {
        return produtoCarrinhoRepository.findAll();
    }

    public ProdutoCarrinho buscarPorId(Long id) {
        return produtoCarrinhoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ProdutoCarrinho not found."));
    }

    public ProdutoCarrinho cadastrar(ProdutoCarrinho produtoCarrinho) {
        return produtoCarrinhoRepository.saveAndFlush(produtoCarrinho);
    }

    public ProdutoCarrinho atualizar(ProdutoCarrinho produtoCarrinho) {
        return produtoCarrinhoRepository.saveAndFlush(produtoCarrinho);
    }

    public void excluir(Long id) {
        ProdutoCarrinho produtoCarrinho = produtoCarrinhoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ProdutoCarrinho not found."));
        produtoCarrinhoRepository.delete(produtoCarrinho);
    }
}
