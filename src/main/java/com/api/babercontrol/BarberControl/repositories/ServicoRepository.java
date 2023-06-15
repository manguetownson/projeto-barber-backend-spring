package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
