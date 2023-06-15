package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProdutoService {
    List<Produto> findAll();
}
