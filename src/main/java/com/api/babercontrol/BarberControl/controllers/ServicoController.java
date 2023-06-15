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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/servico/{id}")
    public ResponseEntity<Object> updateServico(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid ServicoDTO servicoDTO) {
        Optional<Servico> servico0 = servicoRepository.findById(id);
        if(servico0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("servico não encontrado");
        }
        var servicoModel = servico0.get();
        BeanUtils.copyProperties(servicoDTO, servicoModel);
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.save(servicoModel));
    }
    @DeleteMapping("/servico/{id}")
    public ResponseEntity<Object> deleteServico(@PathVariable(value="id") Long id){
        Optional<Servico> servico0 = servicoRepository.findById(id);
        if(servico0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("servico não encontrado");
        }
        servicoRepository.delete(servico0.get());
        return ResponseEntity.status(HttpStatus.OK).body("serviço deletado");
    }
}
