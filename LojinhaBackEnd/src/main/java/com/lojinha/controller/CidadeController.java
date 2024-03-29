package com.lojinha.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lojinha.entity.Cidade;
import com.lojinha.service.CidadeService;



import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscaTodos() {
        return cidadeService.buscaTodos();
    }

    @PostMapping("/")
    public Cidade cadastrar(@Valid @RequestBody Cidade cidade) {
        return cidadeService.cadastrar(cidade);
    }

    @PutMapping("/")
    public Cidade atualizar(@Valid @RequestBody Cidade cidade) {
        return cidadeService.atualizar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        try {
            cidadeService.excluir(id);
            return ResponseEntity.ok("Cidade excluida com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(cidadeService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi possivel achar a cidade");
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (!file.isEmpty()) {
            try {
                cidadeService.salvarCSV(file);
                message = "sucesso no upload" + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body("teste");
            } catch (Exception e) {
                message = "não foi possivel fazer o upload" + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("teste");
            }
        }

        message = "Porfavor faça o upload do CSV!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("teste");
    }

}