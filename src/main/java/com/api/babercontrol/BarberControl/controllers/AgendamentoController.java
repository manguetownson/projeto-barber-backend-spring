package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.models.Agendamento;
import com.api.babercontrol.BarberControl.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;
    @GetMapping("/agendamento")
    public List<Agendamento> list(){
        return service.findAll();
    }

}
