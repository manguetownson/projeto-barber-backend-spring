package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
