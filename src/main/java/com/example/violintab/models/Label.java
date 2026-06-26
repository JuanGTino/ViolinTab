package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "etiquetas")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Column(nullable = false, name = "nombre")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "partitura_etiquetas",
        joinColumns = @JoinColumn(name = "etiqueta_id"),
        inverseJoinColumns = @JoinColumn(name = "partitura_id")
    )
    private Set<SheetMusic> sheetMusics;

    @ManyToMany
    @JoinTable(
        name = "video_etiquetas",
        joinColumns = @JoinColumn(name = "etiqueta_id"),
        inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private Set<Video> videos;

}
