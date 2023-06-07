package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Agendamento;

import java.util.List;

public interface AgendamentoService {
    List<Agendamento> findAll();
}
