package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
