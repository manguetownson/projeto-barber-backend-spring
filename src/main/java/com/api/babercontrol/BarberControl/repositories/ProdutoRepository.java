package com.api.babercontrol.BarberControl.repositories;

import com.api.babercontrol.BarberControl.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
