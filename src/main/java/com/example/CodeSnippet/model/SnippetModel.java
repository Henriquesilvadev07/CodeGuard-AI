package com.example.CodeSnippet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "codesnippet")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SnippetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String linguagem;

    private String codigoIA;

    private String analise;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoriaModel;

}
