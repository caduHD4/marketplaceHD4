package com.lojinha.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojinha.entity.Estado;
import com.lojinha.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id).get();
    }

    public Estado insert(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado newEstado = estadoRepository.saveAndFlush(estado);
        return newEstado;
    }

    public Estado update(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void delete(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estado not found."));
        estadoRepository.delete(estado);

    }

}