package com.lojinha.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojinha.entity.ProdutoCarrinho;
import com.lojinha.service.ProdutoCarrinhoService;

@RestController
@RequestMapping("/api/produtocarrinho")
@CrossOrigin
public class ProdutoCarrinhoController {

    @Autowired
    private ProdutoCarrinhoService produtoCarrinhoService;

    @GetMapping("/")
    public List<ProdutoCarrinho> buscarTodos() {
        return produtoCarrinhoService.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoCarrinho cadastrar(@Valid @RequestBody ProdutoCarrinho produtoCarrinho) {
        return produtoCarrinhoService.cadastrar(produtoCarrinho);
    }

    @PutMapping("/")
    public ProdutoCarrinho atualizar(@Valid @RequestBody ProdutoCarrinho produtoCarrinho) {
        return produtoCarrinhoService.atualizar(produtoCarrinho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            produtoCarrinhoService.excluir(id);
            return ResponseEntity.ok("ProdutoCarrinho deletado com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(produtoCarrinhoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o produto no carrinho.");
        }
    }
}
