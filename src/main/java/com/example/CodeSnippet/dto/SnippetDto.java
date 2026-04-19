package com.example.CodeSnippet.dto;

import com.example.CodeSnippet.model.CategoriaModel;
import com.example.CodeSnippet.model.Status;

public record SnippetDto(String linguagem,
                         String codigoIA,
                         String analise,
                         Status status, CategoriaModel categoria) {
}
