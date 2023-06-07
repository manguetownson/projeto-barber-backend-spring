package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Servico;
import com.api.babercontrol.BarberControl.repositories.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Override
    @Transactional
    public List<Servico> findAll(){
        return (List<Servico>) repository.findAll();
    }

}
