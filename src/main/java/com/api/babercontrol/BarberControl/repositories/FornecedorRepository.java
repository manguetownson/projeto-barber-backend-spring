package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
