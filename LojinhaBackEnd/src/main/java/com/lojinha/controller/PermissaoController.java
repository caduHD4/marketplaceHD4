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

import com.lojinha.entity.Permissao;
import com.lojinha.service.PermissaoService;


@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @PostMapping("/")
    public Permissao cadastrar(@Valid @RequestBody Permissao permissao) {
        return permissaoService.cadastrar(permissao);
    }

    @PutMapping("/")
    public Permissao atualizar(@Valid @RequestBody Permissao permissao) {
        return permissaoService.atualizar(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            permissaoService.excluir(id);
            return ResponseEntity.ok("Permissao deletada com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> BuscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(permissaoService.BuscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar permissao.");
        }
    }
}