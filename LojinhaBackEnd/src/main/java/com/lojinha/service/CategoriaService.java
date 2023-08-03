package com.lojinha.service;

import com.lojinha.entity.Categoria;
import com.lojinha.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Categoria not found."));
    }

    public Categoria cadastrar(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        Categoria newCategoria = categoriaRepository.saveAndFlush(categoria);
        return newCategoria;
    }

    public Categoria atualizar(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Categoria not found."));
        categoriaRepository.delete(categoria);
    }
}
