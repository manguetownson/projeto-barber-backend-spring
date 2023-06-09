package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.ColaboradorDTO;
import com.api.babercontrol.BarberControl.models.Colaborador;
import com.api.babercontrol.BarberControl.repositories.ColaboradorRepository;
import com.api.babercontrol.BarberControl.services.ColaboradorService;
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
public class ColaboradorController {
    @Autowired
    private ColaboradorService service;

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @GetMapping("/colaborador")
    public List<Colaborador> list() { return service.findAll(); }

    @PostMapping("/colaborador")
    public ResponseEntity<Colaborador> saveColaborador(@RequestBody @Valid ColaboradorDTO colaboradorDTO){
        var ColaboradorModel = new Colaborador();
        BeanUtils.copyProperties(colaboradorDTO, ColaboradorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository.save(ColaboradorModel));
    }
}
