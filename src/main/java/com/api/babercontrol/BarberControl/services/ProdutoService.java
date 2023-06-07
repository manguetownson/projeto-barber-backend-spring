package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> findAll();
}
