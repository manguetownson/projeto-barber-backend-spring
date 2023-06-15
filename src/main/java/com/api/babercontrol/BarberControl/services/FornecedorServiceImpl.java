package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Fornecedor;
import com.api.babercontrol.BarberControl.repositories.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    @Override
    @Transactional
    public List<Fornecedor> findAll(){
        return (List<Fornecedor>) repository.findAll();
    }
}
