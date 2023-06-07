package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Produto;
import com.api.babercontrol.BarberControl.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    @Transactional
    public List<Produto> findAll(){
        return (List<Produto>) repository.findAll();
    }

}
