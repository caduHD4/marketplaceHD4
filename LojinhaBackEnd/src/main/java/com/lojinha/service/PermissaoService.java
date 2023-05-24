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
    private PermissaoRepository PermissaoRepository;

    public List<Permissao> findAll() {
        return PermissaoRepository.findAll();
    }

    public Permissao findById(Long id) {
        return PermissaoRepository.findById(id).get();
    }

    public Permissao insert(Permissao pessoa) {
        pessoa.setDataCriacao(new Date());
        Permissao newPessoa = PermissaoRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public Permissao update(Permissao pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return PermissaoRepository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        Permissao pessoa = PermissaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissao not found."));
        PermissaoRepository.delete(pessoa);

    }

}