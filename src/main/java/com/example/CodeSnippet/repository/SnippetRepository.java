package com.example.CodeSnippet.repository;

import com.example.CodeSnippet.dto.SnippetDto;
import com.example.CodeSnippet.model.SnippetModel;
import com.example.CodeSnippet.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnippetRepository extends JpaRepository<SnippetModel, Long> {

    List<SnippetModel> findByStatus(Status status);
}
