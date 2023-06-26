package com.lojinha.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojinha.entity.Pessoa;
import com.lojinha.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).get();
    }

    public Pessoa insert(Pessoa pessoa) {
        pessoa.setCreationDate(new Date());
        Pessoa newPessoa = pessoaRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public Pessoa update(Pessoa pessoa) {
        pessoa.setUpdateDate(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pessoa not found."));
        pessoaRepository.delete(pessoa);

    }

}