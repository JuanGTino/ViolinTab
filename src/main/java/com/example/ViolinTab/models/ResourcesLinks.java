package com.example.ViolinTab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Entity
@Table(name = "resources_links")
public class ResourcesLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sheet_music_id", nullable = false)
    @NotNull(message = "Sheet music is mandatory")
    private SheetMusic sheetMusic;

    @NotBlank(message = "Resource name is mandatory")
    @URL(message = "Resource name must be a valid URL")
    @Size(max = 1000, message = "Resource name must be less than 1000 characters")
    @Column(name = "url_path", nullable = false, length = 1000)
    private String urlPath;

    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(length = 255)
    private String description;
}
