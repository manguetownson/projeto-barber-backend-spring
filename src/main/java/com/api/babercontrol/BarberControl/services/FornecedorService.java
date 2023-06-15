package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Fornecedor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FornecedorService {
    List<Fornecedor> findAll();
}
