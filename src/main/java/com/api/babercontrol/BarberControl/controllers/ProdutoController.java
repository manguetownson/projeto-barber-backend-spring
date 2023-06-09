package com.api.babercontrol.BarberControl.controllers;

import com.api.babercontrol.BarberControl.dtos.ProdutoDTO;
import com.api.babercontrol.BarberControl.models.Produto;
import com.api.babercontrol.BarberControl.repositories.ProdutoRepository;
import com.api.babercontrol.BarberControl.services.ProdutoService;
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
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> list() { return service.findAll(); }

    @PostMapping("/produto")
    public ResponseEntity<Produto> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        var ProdutoModel = new Produto();
        BeanUtils.copyProperties(produtoDTO, ProdutoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(ProdutoModel));
    }
}
