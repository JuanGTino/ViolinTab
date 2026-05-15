package com.example.ViolinTab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "sheet_music")
public class SheetMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title must be less than 100 characters")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Artist is mandatory")
    @Column(nullable = false)
    private String artist;

    @NotBlank(message = "Category is mandatory")
    @Column(nullable = false)
    private String category;

    @NotBlank(message = "Genre is mandatory")
    @Column(nullable = false)
    private String genre;
    @Column(name = "pdf_path")
    private String pdfPath;

    public enum Status {
        PUBLISHED,
        DRAFT
    }

    @NotNull(message = "Status is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "is_favorite", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean favorite;

}
//Estas validaciones se activan cuando usas @Valid o @Validated en el controller o service
//al recibir los datos. Sin eso, las anotaciones no tienen efecto en tiempo de ejecución.