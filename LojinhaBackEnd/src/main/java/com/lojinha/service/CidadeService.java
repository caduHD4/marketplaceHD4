package com.lojinha.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

import com.lojinha.dto.CidadeDto;
import com.lojinha.entity.Cidade;
import com.lojinha.repository.EstadoRepository;
import com.lojinha.repository.CidadeRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

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
    private CidadeRepository cidadeRepository;
    private static EstadoService estadoService;

     public List<Cidade> buscaTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).get();
    }

    public Cidade cadastrar(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        Cidade newCidade = cidadeRepository.saveAndFlush(cidade);
        return newCidade;
    }

    public Cidade atualizar(Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void excluir(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cidade não encontrada."));
        cidadeRepository.delete(cidade);

    }

    public void salvarCSV(MultipartFile file) {

        try {
            BufferedReader fileReader = new BufferedReader(new
                    InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            ArrayList<CidadeDto> cities = new ArrayList<>();

            Cidade cidade = new Cidade();

            for (CSVRecord csvRecord : csvRecords) {
                CidadeDto cidadeDto = new CidadeDto(
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("nome"),
                        Long.parseLong(csvRecord.get("estado_id"))
                );
            }

            for(CidadeDto cidadeDto : cities){
                cidade.setId(cidadeDto.getId());
                cidade.setNome(cidadeDto.getNome());
                cidade.setEstado(estadoService.BuscarPorId(cidadeDto.getEstadoId()));
                cadastrar(cidade);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}