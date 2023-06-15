package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
