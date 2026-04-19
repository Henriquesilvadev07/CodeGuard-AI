package com.example.CodeSnippet.service;

import com.example.CodeSnippet.dto.SnippetDto;
import com.example.CodeSnippet.model.SnippetModel;
import com.example.CodeSnippet.model.Status;
import com.example.CodeSnippet.repository.SnippetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

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

        return snippetRepository.save(snippet);
    }

    public List<SnippetModel> listarPendentes() {
        return snippetRepository.findByStatus(Status.REVISAO);
    }

    public SnippetModel atualizar(SnippetDto dto) {
        SnippetModel snippet = new SnippetModel();
        snippet.setAnalise(dto.analise());
        snippet.setLinguagem(dto.linguagem());
        snippet.setCodigoIA(dto.codigoIA());
        snippet.setStatus(dto.status());

        return snippetRepository.saveAndFlush(snippet);
    }

    public void deletarPorId(Long id){
        if (snippetRepository.existsById(id)) {
            snippetRepository.deleteById(id);
        }
    }


}
