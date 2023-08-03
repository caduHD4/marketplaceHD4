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

import com.lojinha.entity.CarrinhoCompras;
import com.lojinha.service.CarrinhoComprasService;

@RestController
@RequestMapping("/api/carrinhocompras")
@CrossOrigin
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoComprasService carrinhoComprasService;

    @GetMapping("/")
    public List<CarrinhoCompras> buscarTodos() {
        return carrinhoComprasService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompras cadastrar(@Valid @RequestBody CarrinhoCompras carrinhoCompras) {
        return carrinhoComprasService.cadastrar(carrinhoCompras);
    }

    @PutMapping("/")
    public CarrinhoCompras atualizar(@Valid @RequestBody CarrinhoCompras carrinhoCompras) {
        return carrinhoComprasService.atualizar(carrinhoCompras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            carrinhoComprasService.excluir(id);
            return ResponseEntity.ok("Carrinho de compras deletado com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(carrinhoComprasService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o carrinho de compras.");
        }
    }
}
