package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Colaborador;
import com.api.babercontrol.BarberControl.repositories.ColaboradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{
    @Autowired
    private ColaboradorRepository repository;

    @Override
    @Transactional
    public List<Colaborador> findAll(){
        return (List<Colaborador>) repository.findAll();
    }

}
