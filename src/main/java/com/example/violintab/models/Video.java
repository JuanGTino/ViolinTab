package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    @Column(nullable = false, name = "titulo")
    private String title;

    @Column(name="descripcion", columnDefinition = "TEXT")
    private String description;

    public enum typeFont{
        LOCAL,
        YOUTUBE,
        URL_EXTERNA
    }

    @Column(name="tipo_fuente",  nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'local'")
    @Enumerated(EnumType.STRING)
    private typeFont typeFont;

    @NotBlank(message = "URL is mandatory")
    @Column(nullable = false, name = "url_o_ruta")
    private String url;

    @Size(max = 20, message = "YouTube ID must be less than 20 characters")
    @Column(name="youtube_id")
    private String youtube;

    @Column(name = "duracion_seg")
    private Integer durationSeconds;

    @Column(name = "miniatura_url", columnDefinition = "TEXT")
    private String miniatureUrl;

    @Column(name = "tiene_musica", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean hasMusic;

    public enum NevelDifficulty{
        PRINCIPIANTE,
        INTERMEDIO,
        AVANZADO,
        PROFESIONAL
    }

    @Column(name = "nivel_dificultad", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PRINCIPIANTE'")
    @Enumerated(EnumType.STRING)
    private NevelDifficulty difficulty;

    @Column(name = "favorito", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean favorite;

    @ManyToMany
    @JoinTable(name = "video_etiquetas",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
    private Set<Label> labels;
}
