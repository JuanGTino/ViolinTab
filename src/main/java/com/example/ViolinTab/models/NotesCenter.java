package com.example.ViolinTab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes_center")
public class NotesCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sheet_music_id", nullable = false)
    @NotNull(message = "Sheet music is mandatory")
    private SheetMusic sheetMusic;

    public enum NoteType {
        TEXT,
        AUDIO,
        VIDEO
    }

    @NotNull(message = "Note type is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(name = "note_type", nullable = false)
    private NoteType noteType;

    @NotBlank(message = "Content is mandatory")
    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(max = 5000, message = "Content must be less than 5000 characters")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
