package com.api.babercontrol.BarberControl.services;


import com.api.babercontrol.BarberControl.models.Cliente;
import com.api.babercontrol.BarberControl.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements  ClienteService{



    @Autowired
    private ClienteRepository repository;
    @Override
    @Transactional
    public List<Cliente> findAll() {

        return (List<Cliente>) repository.findAll();
    }
}
