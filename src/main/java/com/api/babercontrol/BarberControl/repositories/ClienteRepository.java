package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
