package com.lojinha.service;

import com.lojinha.entity.CarrinhoCompras;
import com.lojinha.repository.CarrinhoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarrinhoComprasService {

    @Autowired
    private CarrinhoComprasRepository carrinhoComprasRepository;

    public List<CarrinhoCompras> buscarTodos() {
        return carrinhoComprasRepository.findAll();
    }

    public CarrinhoCompras buscarPorId(Long id) {
        return carrinhoComprasRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Carrinho de compras not found."));
    }

    public CarrinhoCompras cadastrar(CarrinhoCompras carrinhoCompras) {
        return carrinhoComprasRepository.saveAndFlush(carrinhoCompras);
    }

    public CarrinhoCompras atualizar(CarrinhoCompras carrinhoCompras) {
        return carrinhoComprasRepository.saveAndFlush(carrinhoCompras);
    }

    public void excluir(Long id) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carrinho de compras not found."));
        carrinhoComprasRepository.delete(carrinhoCompras);
    }
}
