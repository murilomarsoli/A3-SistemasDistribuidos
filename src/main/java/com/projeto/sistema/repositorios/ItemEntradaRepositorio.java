package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Entrada;
import com.projeto.sistema.modelos.ItemEntrada;

public interface ItemEntradaRepositorio extends JpaRepository<ItemEntrada, Long> {

    // Método para deletar todos os itens relacionados a uma entrada
    void deleteAllByEntrada(Entrada entrada);
}


