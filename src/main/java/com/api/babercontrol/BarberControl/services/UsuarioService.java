package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioService {
    List<Usuario> findAll();
}
