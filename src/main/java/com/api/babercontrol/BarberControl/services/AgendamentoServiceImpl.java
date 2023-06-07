package com.api.babercontrol.BarberControl.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.babercontrol.BarberControl.models.Agendamento;
import com.api.babercontrol.BarberControl.repositories.AgendamentoRepository;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    @Autowired
    private AgendamentoRepository repository;
    @Override
    @Transactional
    public List<Agendamento> findAll(){
        return (List<Agendamento>) repository.findAll();
    }
}
