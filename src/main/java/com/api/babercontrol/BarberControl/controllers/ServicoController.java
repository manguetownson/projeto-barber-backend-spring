package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.ServicoDTO;
import com.api.babercontrol.BarberControl.models.Servico;
import com.api.babercontrol.BarberControl.repositories.ServicoRepository;
import com.api.babercontrol.BarberControl.services.ServicoService;
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
public class ServicoController {

    @Autowired
    private ServicoService service;

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping("/servico")
    public List<Servico> list() { return service.findAll(); }

    @PostMapping("/servico")
    public ResponseEntity<Servico> saveServico(@RequestBody @Valid ServicoDTO servicoDTO){
        var ServicoModel = new Servico();
        BeanUtils.copyProperties(servicoDTO, ServicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoRepository.save(ServicoModel));
    }
}
