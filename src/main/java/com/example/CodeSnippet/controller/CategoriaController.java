package com.example.CodeSnippet.controller;

import com.example.CodeSnippet.model.CategoriaModel;
import com.example.CodeSnippet.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaModel> salvar(@RequestBody CategoriaModel categoria) {
        return ResponseEntity.ok(categoriaRepository.save(categoria));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listar() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }


}
