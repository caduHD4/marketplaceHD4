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
    private PermissaoPessoaRepository PermissaoPessoaRepository;

    public List<PermissaoPessoa> findAll() {
        return PermissaoPessoaRepository.findAll();
    }

    public PermissaoPessoa findById(Long id) {
        return PermissaoPessoaRepository.findById(id).get();
    }

    public PermissaoPessoa insert(PermissaoPessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        PermissaoPessoa newPessoa = PermissaoPessoaRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public PermissaoPessoa update(PermissaoPessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return PermissaoPessoaRepository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        PermissaoPessoa pessoa = PermissaoPessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PermissaoPessoa not found."));
        PermissaoPessoaRepository.delete(pessoa);

    }

}