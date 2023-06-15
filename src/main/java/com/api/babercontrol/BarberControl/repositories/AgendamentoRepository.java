package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
