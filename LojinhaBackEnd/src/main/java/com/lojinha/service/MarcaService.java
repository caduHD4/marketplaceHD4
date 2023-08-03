package com.lojinha.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojinha.entity.Marca;
import com.lojinha.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Marca not found."));
    }

    public Marca cadastrar(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca newMarca = marcaRepository.saveAndFlush(marca);
        return newMarca;
    }

    public Marca atualizar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Marca not found."));
        marcaRepository.delete(marca);
    }
}
