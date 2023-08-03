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

import com.lojinha.entity.Categoria;
import com.lojinha.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> buscarTodos() {
        return categoriaService.buscarTodos();
    }

    @PostMapping("/")
    public Categoria cadastrar(@Valid @RequestBody Categoria categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @PutMapping("/")
    public Categoria atualizar(@Valid @RequestBody Categoria categoria) {
        return categoriaService.atualizar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            categoriaService.excluir(id);
            return ResponseEntity.ok("Categoria deletada com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(categoriaService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a categoria.");
        }
    }
}
