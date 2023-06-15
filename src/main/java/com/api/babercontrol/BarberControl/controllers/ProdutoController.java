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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/produto/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid ProdutoDTO produtoDTO) {
        Optional<Produto> produto0 = produtoRepository.findById(id);
        if(produto0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }
        var produtoModel = produto0.get();
        BeanUtils.copyProperties(produtoDTO, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoModel));
    }
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Object> deleteAgendamento(@PathVariable(value="id") Long id){
        Optional<Produto> produto0 = produtoRepository.findById(id);
        if(produto0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }
        produtoRepository.delete(produto0.get());
        return ResponseEntity.status(HttpStatus.OK).body("produto deletado");
    }
}
