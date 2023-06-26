package com.lojinha.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojinha.entity.PermissaoPessoa;
import com.lojinha.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    public List<PermissaoPessoa> findAll() {
        return permissaoPessoaRepository.findAll();
    }

    public PermissaoPessoa findById(Long id) {
        return permissaoPessoaRepository.findById(id).get();
    }

    public PermissaoPessoa insert(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setCreationDate(new Date());
        PermissaoPessoa newPermissaoPessoa = permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        return newPermissaoPessoa;
    }

    public PermissaoPessoa update(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setUpdateDate(new Date());
        return permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
    }

    public void delete(Long id) {
        PermissaoPessoa permissaoPessoa = permissaoPessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PermissaoPessoa not found."));
        permissaoPessoaRepository.delete(permissaoPessoa);

    }

}