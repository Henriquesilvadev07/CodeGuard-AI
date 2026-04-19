package com.example.CodeSnippet.service;

import com.example.CodeSnippet.dto.SnippetDto;
import com.example.CodeSnippet.model.CategoriaModel;
import com.example.CodeSnippet.model.SnippetModel;
import com.example.CodeSnippet.model.Status;
import com.example.CodeSnippet.repository.SnippetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SnippetService {

    private final SnippetRepository snippetRepository;

    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public SnippetModel salvar(SnippetDto dto) {
        SnippetModel snippet = new SnippetModel();
        snippet.setAnalise(dto.analise());
        snippet.setLinguagem(dto.linguagem());
        snippet.setCodigoIA(dto.codigoIA());
        snippet.setStatus(dto.status());
        snippet.setCategoriaModel(dto.categoria());

        return snippetRepository.save(snippet);
    }

    public List<SnippetModel> listarTodos() {
        return snippetRepository.findAll();
    }

    public SnippetModel atualizar(Long id, SnippetDto dto) {
        SnippetModel snippet = snippetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Snippet não encontrado"));
        snippet.setAnalise(dto.analise());
        snippet.setLinguagem(dto.linguagem());
        snippet.setCodigoIA(dto.codigoIA());
        snippet.setStatus(dto.status());
        snippet.setCategoriaModel(dto.categoria());

        return snippetRepository.save(snippet);
    }
    public void deletarPorId(Long id){
        if (snippetRepository.existsById(id)) {
            snippetRepository.deleteById(id);
        }
    }
}