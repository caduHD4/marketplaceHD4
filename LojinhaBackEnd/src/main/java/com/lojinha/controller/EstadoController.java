package com.lojinha.controller;

import com.lojinha.entity.Estado;
import com.lojinha.service.EstadoService;

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

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoService.bucarTodos();
    }

    @PostMapping("/")
    public Estado cadastrar(@RequestBody Estado estado) {
        return estadoService.cadastrar(estado);
    }

    @PutMapping("/")
    public Estado atualizar(@RequestBody Estado estado) {
        return estadoService.atualizar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            estadoService.excluir(id);
            return ResponseEntity.ok("Estado excluido com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> BuscarPorId (@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(estadoService.BuscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não foi possivel encontrar o estado");
        }
    }
}