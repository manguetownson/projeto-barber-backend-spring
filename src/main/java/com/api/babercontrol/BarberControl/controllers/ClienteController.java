package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.models.Cliente;
import com.api.babercontrol.BarberControl.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    private ClienteService service;

    @GetMapping("/cliente")
    public List<Cliente> list() { return service.findAll(); }
}
