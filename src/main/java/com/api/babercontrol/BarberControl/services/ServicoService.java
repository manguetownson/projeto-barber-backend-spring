package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Servico;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ServicoService {
    List<Servico> findAll();
}
