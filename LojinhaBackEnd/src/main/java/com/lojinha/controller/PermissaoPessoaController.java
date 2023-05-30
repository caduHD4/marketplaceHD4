package com.lojinha.controller;


import java.util.List;
import java.util.NoSuchElementException;

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
    public List<PermissaoPessoa> findAll() {
        return permissaoPessoaService.findAll();
    }

    @PostMapping("/")
    public PermissaoPessoa insert(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaService.insert(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa update(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaService.update(permissaoPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            permissaoPessoaService.delete(id);
            return ResponseEntity.ok("PermissaoPessoa successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(permissaoPessoaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find the permissaoPessoa.");
        }
    }
}