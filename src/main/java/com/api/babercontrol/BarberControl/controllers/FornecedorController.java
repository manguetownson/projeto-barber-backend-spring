package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.FornecedorDTO;
import com.api.babercontrol.BarberControl.models.Fornecedor;
import com.api.babercontrol.BarberControl.repositories.FornecedorRepository;
import com.api.babercontrol.BarberControl.services.FornecedorService;
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
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @GetMapping("/fornecedor")
    public List<Fornecedor> list() { return service.findAll(); }

    @PostMapping("/fornecedor")
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody @Valid FornecedorDTO fornecedorDTO){
        var FornecedorModel = new Fornecedor();
        BeanUtils.copyProperties(fornecedorDTO, FornecedorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(FornecedorModel));
    }
}
