package com.lojinha.service;

import com.lojinha.entity.ImagemProduto;
import com.lojinha.repository.ImagemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ImagemProdutoService {

    @Autowired
    private ImagemProdutoRepository imagemProdutoRepository;

    public List<ImagemProduto> buscarTodos() {
        return imagemProdutoRepository.findAll();
    }

    public ImagemProduto buscarPorId(Long id) {
        return imagemProdutoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ImagemProduto not found."));
    }

    public ImagemProduto cadastrar(ImagemProduto imagemProduto) {
        return imagemProdutoRepository.saveAndFlush(imagemProduto);
    }

    public ImagemProduto atualizar(ImagemProduto imagemProduto) {
        return imagemProdutoRepository.saveAndFlush(imagemProduto);
    }

    public void excluir(Long id) {
        ImagemProduto imagemProduto = imagemProdutoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ImagemProduto not found."));
        imagemProdutoRepository.delete(imagemProduto);
    }
}
