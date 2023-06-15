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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/colaborador/{id}")
    public ResponseEntity<Object> updateColaborador(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid ColaboradorDTO colaboradorDTO) {
        Optional<Colaborador> colaborador0 = colaboradorRepository.findById(id);
        if(colaborador0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("colaborador não encontrado");
        }
        var colaboradorModel = colaborador0.get();
        BeanUtils.copyProperties(colaboradorDTO, colaboradorModel);
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.save(colaboradorModel));
    }
    @DeleteMapping("/colaborador/{id}")
    public ResponseEntity<Object> deleteColaborador(@PathVariable(value="id") Long id){
        Optional<Colaborador> colaborador0 = colaboradorRepository.findById(id);
        if(colaborador0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("colaborador não encontrado");
        }
        colaboradorRepository.delete(colaborador0.get());
        return ResponseEntity.status(HttpStatus.OK).body("colaborador deletado");
    }
}
