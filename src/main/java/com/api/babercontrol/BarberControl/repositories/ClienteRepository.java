package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
