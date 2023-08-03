package com.lojinha.service;

import com.lojinha.entity.Produto;
import com.lojinha.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto not found."));
    }

    public Produto cadastrar(Produto produto) {
        produto.setDataCriacao(new Date());
        Produto newProduto = produtoRepository.saveAndFlush(produto);
        return newProduto;
    }

    public Produto atualizar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void excluir(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto not found."));
        produtoRepository.delete(produto);
    }
}
