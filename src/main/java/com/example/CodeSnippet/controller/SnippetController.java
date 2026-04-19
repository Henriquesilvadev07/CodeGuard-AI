package com.example.CodeSnippet.controller;

import com.example.CodeSnippet.dto.SnippetDto;
import com.example.CodeSnippet.model.SnippetModel;
import com.example.CodeSnippet.repository.SnippetRepository;
import com.example.CodeSnippet.service.SnippetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SnippetController {

    private final SnippetService snippetService;
    private final SnippetRepository snippetRepository;

    public SnippetController(SnippetService snippetService, SnippetRepository snippetRepository) {
        this.snippetService = snippetService;
        this.snippetRepository = snippetRepository;
    }

    @PostMapping
    public ResponseEntity<SnippetModel> salvar(@RequestBody SnippetDto dto){
        return ResponseEntity.ok(snippetService.salvar(dto));
    }

    @GetMapping("/Todos")
    public ResponseEntity<List<SnippetModel>> todos(){
        return ResponseEntity.ok(snippetRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SnippetModel> atualizar(@PathVariable Long id, @RequestBody SnippetDto dto) {
        return ResponseEntity.ok(snippetService.atualizar(id, dto));
    }

    @DeleteMapping
    public void deletar(@RequestParam Long id) {
        snippetService.deletarPorId(id);
    }
}