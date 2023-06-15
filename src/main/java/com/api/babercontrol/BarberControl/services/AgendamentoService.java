package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Agendamento;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AgendamentoService {
    List<Agendamento> findAll();
}
