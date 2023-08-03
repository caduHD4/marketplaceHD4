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

import com.lojinha.entity.PermissaoPessoa;
import com.lojinha.service.PermissaoPessoaService;



@RestController
@RequestMapping("/api/permissaoPessoa")
@CrossOrigin
public class PermissaoPessoaController {

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @GetMapping("/")
    public List<PermissaoPessoa> buscarTodos() {
        return permissaoPessoaService.buscarTodos();
    }

    @PostMapping("/")
    public PermissaoPessoa cadastar(@Valid @RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaService.cadastrar(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa atualizar(@Valid @RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaService.atualizar(permissaoPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            permissaoPessoaService.excluir(id);
            return ResponseEntity.ok("PermissaoPessoa deletado com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(permissaoPessoaService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não foi possivel encontrar permissaoPessoa.");
        }
    }
}