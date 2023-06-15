package com.api.babercontrol.BarberControl.services;

import com.api.babercontrol.BarberControl.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteService {
    List<Cliente> findAll();
}
