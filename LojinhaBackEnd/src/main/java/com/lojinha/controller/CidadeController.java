package com.lojinha.controller;

import com.lojinha.dto.CidadeDto;
import com.lojinha.entity.Cidade;
import com.lojinha.service.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping()
    public void cadastrar(@RequestBody CidadeDto cidade) {
        cidadeService.cadastrar(cidade);
    }

    @GetMapping()
    public List<Cidade> listarTodos() {
        return cidadeService.listarTodos();
    }

    @GetMapping(params = "id")
    public Cidade buscarPorId(@RequestParam Long id) {
        return cidadeService.buscarPorId(id);
    }

    @GetMapping(params = "nome")
    public List<Cidade> buscarPorNome(@RequestParam String nome) {
        return cidadeService.buscarPorNome(nome);
    }

    @PutMapping()
    public void atualizar(@RequestBody CidadeDto cidadeDto) {
        cidadeService.atualizar(cidadeDto);
    }

    @DeleteMapping()
    public void excluir(@RequestParam Long id) {
        cidadeService.excluir(id);
    }
}
