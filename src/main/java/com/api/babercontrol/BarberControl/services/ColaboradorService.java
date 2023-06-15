package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Colaborador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ColaboradorService {
    List<Colaborador> findAll();
}
