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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/fornecedor/{id}")
    public ResponseEntity<Object> updateFornecedor(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid FornecedorDTO fornecedorDTO) {
        Optional<Fornecedor> fornecedor0 = fornecedorRepository.findById(id);
        if(fornecedor0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fornecedor não encontrado");
        }
        var fornecedorModel = fornecedor0.get();
        BeanUtils.copyProperties(fornecedorDTO, fornecedorModel);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.save(fornecedorModel));
    }
    @DeleteMapping("/fornecedor/{id}")
    public ResponseEntity<Object> deleteFornecedor(@PathVariable(value="id") Long id){
        Optional<Fornecedor> fornecedor0 = fornecedorRepository.findById(id);
        if(fornecedor0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("fornecedor não encontrado");
        }
        fornecedorRepository.delete(fornecedor0.get());
        return ResponseEntity.status(HttpStatus.OK).body("fornecedor deletado");
    }
}
