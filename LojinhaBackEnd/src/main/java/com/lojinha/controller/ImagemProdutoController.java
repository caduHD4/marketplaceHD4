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

import com.lojinha.entity.ImagemProduto;
import com.lojinha.service.ImagemProdutoService;

@RestController
@RequestMapping("/api/imagemproduto")
@CrossOrigin
public class ImagemProdutoController {

    @Autowired
    private ImagemProdutoService imagemProdutoService;

    @GetMapping("/")
    public List<ImagemProduto> buscarTodos() {
        return imagemProdutoService.buscarTodos();
    }

    @PostMapping("/")
    public ImagemProduto cadastrar(@Valid @RequestBody ImagemProduto imagemProduto) {
        return imagemProdutoService.cadastrar(imagemProduto);
    }

    @PutMapping("/")
    public ImagemProduto atualizar(@Valid @RequestBody ImagemProduto imagemProduto) {
        return imagemProdutoService.atualizar(imagemProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            imagemProdutoService.excluir(id);
            return ResponseEntity.ok("ImagemProduto deletada com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(imagemProdutoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a imagem do produto.");
        }
    }
}
