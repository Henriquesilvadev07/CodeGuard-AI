package com.example.CodeSnippet.repository;

import com.example.CodeSnippet.dto.SnippetDto;
import com.example.CodeSnippet.model.SnippetModel;
import com.example.CodeSnippet.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnippetRepository extends JpaRepository<SnippetModel, Long> {

    List<SnippetModel> findByStatus(Status status);
}
