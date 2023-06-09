package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
