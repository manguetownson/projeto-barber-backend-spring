package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
