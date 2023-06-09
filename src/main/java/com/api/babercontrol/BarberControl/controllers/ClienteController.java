package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.ClienteDTO;
import com.api.babercontrol.BarberControl.models.Cliente;
import com.api.babercontrol.BarberControl.repositories.ClienteRepository;
import com.api.babercontrol.BarberControl.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService service;
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> list() { return service.findAll(); }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        var ClienteModel = new Cliente();
        BeanUtils.copyProperties(clienteDTO, ClienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(ClienteModel));
    }
}
