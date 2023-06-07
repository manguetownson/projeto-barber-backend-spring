package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Usuario;
import com.api.babercontrol.BarberControl.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional
    public List<Usuario> findAll(){
        return (List<Usuario>) repository.findAll();
    }
}
