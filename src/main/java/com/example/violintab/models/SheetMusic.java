package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "partituras")
public class SheetMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;

    @ManyToOne
    @JoinColumn(name = "compositor_id",  nullable = false)
    @NotNull(message = "Composer is mandatory")
    private Composer composerEntity;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    @Column(nullable = false, name = "titulo")
    private String title;

    @NotBlank(message = "Opus is mandatory")
    @Size(max = 50, message = "Opus must be less than 50 characters")
    @Column(nullable = false)
    private String opus;

    @NotBlank(message = "Tonality is mandatory")
    @Size(max = 20, message = "Tonality must be less than 50 characters")
    @Column(nullable = false, name = "tonalidad")
    private String tonality;

    public enum difficulty {
        PRINCIPIANTE,
        INTERMEDIO,
        AVANZADO,
        PROFESSIONAL
    }

    @NotNull(message = "Difficulty is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PRINCIPIANTE'", name="nivel_dificultad")
    private difficulty difficulty;

    public enum typeFile {
        PDF,
        MUSICXML,
        JPG,
        PNG
    }

    @Column(name = "tipo_archivo", nullable = false)
    private typeFile typeFile;

    @NotBlank(message = "File path is mandatory")
    @Column(nullable = false, name = "ruta_archivo")
    private String filePath;

    @Column(name = "miniatura_url", nullable = true)
    private String urlMiniature;

    @Column(name = "total_paginas", columnDefinition = "INT DEFAULT 1")
    private int totalPages;

    @Column(name = "favorita", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean favorite;

    public enum status {
        PENDENTE,
        EN_PROGRESO,
        APRENDIDA
    }

    @Column(name = "estado", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PENDENTE'")
    @Enumerated(EnumType.STRING)
    private status status;

    @Column(name = "notas_generales", nullable = true, columnDefinition = "TEXT")
    private String generalNotes;

    @ManyToMany
    @JoinTable(
        name = "partitura_etiquetas",
        joinColumns = @JoinColumn(name = "partitura_id"),
        inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private Set<Label> labels;
}
//Estas validaciones se activan cuando usas @Valid o @Validated en el controller o service
//al recibir los datos. Sin eso, las anotaciones no tienen efecto en tiempo de ejecución.