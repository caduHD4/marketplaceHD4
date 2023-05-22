package com.lojinha.service;

import com.lojinha.dto.EstadoDto;
import com.lojinha.entity.Estado;
import com.lojinha.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public void cadastrar(EstadoDto estadoDto) {
        Estado estado = new Estado();
        estado.setSigla(estadoDto.getSigla());
        estado.setNome(estadoDto.getNome());
        estadoRepository.save(estado);
    }

    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    public Estado buscarPorId(Long id) {

        try {
            Optional<Estado> EstadoOptional = estadoRepository.findById(id);

            if(EstadoOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }

            return EstadoOptional.get();

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Estado> buscarPorNome(String nome) {

        try {
            List<Estado> EstadoList = estadoRepository.findByNomeContainingIgnoreCase(nome);

            if(EstadoList.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }

            return EstadoList;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(EstadoDto estadoDto) {
        try {
            validarAtualizacaoEstado(estadoDto);
            Estado estado = new Estado();
            estado.setSigla(estadoDto.getSigla());
            estado.setNome(estadoDto.getNome());
            estadoRepository.save(estado);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Estado estado = new Estado();
        estado.setId(id);
        estadoRepository.delete(estado);
    }

    private void validarAtualizacaoEstado(EstadoDto estadoDto) throws ResponseStatusException {
        try {

            if(estadoDto == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um estado para atualizar");
            }

            if(estadoDto.getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe o id do estado para atualizar");
            }
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }
}
