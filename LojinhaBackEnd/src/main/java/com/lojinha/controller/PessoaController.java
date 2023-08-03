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

import com.lojinha.entity.Pessoa;
import com.lojinha.service.PessoaService;


@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaService pessoaServico;

    @GetMapping("/")
    public List<Pessoa> buscarTodos() {
        return pessoaServico.buscarTodos();
    }

    @PostMapping("/")
    public Pessoa cadastrar(@Valid @RequestBody Pessoa pessoa) {
        return pessoaServico.cadastrar(pessoa);
    }

    @PutMapping("/")
    public Pessoa atualizar(@Valid @RequestBody Pessoa pessoa) {
        return pessoaServico.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            pessoaServico.excluir(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(pessoaServico.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar pessoa.");
        }
    }
}