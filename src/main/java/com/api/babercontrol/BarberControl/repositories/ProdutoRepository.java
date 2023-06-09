package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
