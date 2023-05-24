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
    private PessoaRepository PessoaRepository;

    public List<Pessoa> findAll() {
        return PessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return PessoaRepository.findById(id).get();
    }

    public Pessoa insert(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa newPessoa = PessoaRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public Pessoa update(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return PessoaRepository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        Pessoa pessoa = PessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pessoa not found."));
        PessoaRepository.delete(pessoa);

    }

}