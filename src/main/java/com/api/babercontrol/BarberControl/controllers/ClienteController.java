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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid ClienteDTO clienteDTO) {
        Optional<Cliente> cliente0 = clienteRepository.findById(id);
        if(cliente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente não encontrado");
        }
        var clienteModel = cliente0.get();
        BeanUtils.copyProperties(clienteDTO, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value="id") Long id){
        Optional<Cliente> cliente0 = clienteRepository.findById(id);
        if(cliente0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente não encontrado");
        }
        clienteRepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("cliente deletado");
    }
}
