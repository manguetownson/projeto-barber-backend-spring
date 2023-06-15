package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.AgendamentoDTO;
import com.api.babercontrol.BarberControl.models.Agendamento;
import com.api.babercontrol.BarberControl.repositories.AgendamentoRepository;
import com.api.babercontrol.BarberControl.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AgendamentoController {

    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    private AgendamentoService service;
    @GetMapping("/agendamento")
    public ResponseEntity<List<Agendamento>> getAllAgendamento(){

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @PostMapping("/agendamento")
    public ResponseEntity<Agendamento> saveAgendamento(@RequestBody @Valid AgendamentoDTO agendamentoDTO){
        var AgendamentoModel = new Agendamento();
        BeanUtils.copyProperties(agendamentoDTO, AgendamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoRepository.save(AgendamentoModel));
    }

    @PutMapping("/agendamento/{id}")
    public ResponseEntity<Object> updateAgendamento(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid AgendamentoDTO agendamentoDTO) {
        Optional<Agendamento> agendamento0 = agendamentoRepository.findById(id);
        if(agendamento0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("agendamento não encontrado");
        }
        var agendamentoModel = agendamento0.get();
        BeanUtils.copyProperties(agendamentoDTO, agendamentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.save(agendamentoModel));
    }
    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<Object> deleteAgendamento(@PathVariable(value="id") Long id){
        Optional<Agendamento> agendamento0 = agendamentoRepository.findById(id);
        if(agendamento0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("agendamento não encontrado");
        }
        agendamentoRepository.delete(agendamento0.get());
        return ResponseEntity.status(HttpStatus.OK).body("agendamento deletado");
    }

}
