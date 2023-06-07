package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Fornecedor;
import com.api.babercontrol.BarberControl.repositories.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    private FornecedorRepository repository;

    @Override
    @Transactional
    public List<Fornecedor> findAll(){
        return (List<Fornecedor>) repository.findAll();
    }
}
