package com.lojinha.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojinha.entity.Permissao;
import com.lojinha.repository.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }

    public Permissao findById(Long id) {
        return permissaoRepository.findById(id).get();
    }

    public Permissao insert(Permissao permissao) {
        permissao.setCreationDate(new Date());
        Permissao newPermissao = permissaoRepository.saveAndFlush(permissao);
        return newPermissao;
    }

    public Permissao update(Permissao permissao) {
        permissao.setUpdateDate(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void delete(Long id) {
        Permissao permissao = permissaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissao not found."));
        permissaoRepository.delete(permissao);

    }

}