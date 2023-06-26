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

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).get();
    }

    public Pessoa cadastrar(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa newPessoa = pessoaRepository.saveAndFlush(pessoa);
        return newPessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pessoa not found."));
        pessoaRepository.delete(pessoa);

    }

}