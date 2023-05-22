package com.lojinha.service;

import com.lojinha.dto.CidadeDto;
import com.lojinha.entity.Cidade;
import com.lojinha.entity.Estado;
import com.lojinha.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public void cadastrar(CidadeDto cidadeDto) {
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        cidade.setNome(cidadeDto.getNome());
        estado.setId(cidadeDto.getEstadoDto().getId());
        cidade.setEstado(estado);
        cidadeRepository.save(cidade);
    }

    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {

        try {
            Optional<Cidade> cidadeOptional = cidadeRepository.findById(id);

            if(cidadeOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma cidade foi encontrada");
            }

            return cidadeOptional.get();

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Cidade> buscarPorNome(String nome) {

        try {
            List<Cidade> cidadeList = cidadeRepository.findByNomeContainingIgnoreCase(nome);

            if(cidadeList.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma cidade foi encontrada");
            }

            return cidadeList;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(CidadeDto cidadeDto) {
        try {
            validarAtualizacaoCidade(cidadeDto);
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            cidade.setId(cidadeDto.getId());
            cidade.setNome(cidadeDto.getNome());
            estado.setId(cidadeDto.getEstadoDto().getId());
            cidade.setEstado(estado);
            cidadeRepository.save(cidade);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Cidade cidade = new Cidade();
        cidade.setId(id);
        cidadeRepository.delete(cidade);
    }

    private void validarAtualizacaoCidade(CidadeDto cidadeDto) throws ResponseStatusException {
        try {

            if(cidadeDto == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe uma cidade para atualizar");
            }

            if(cidadeDto.getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe o id da cidade para atualizar");
            }
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }
}
