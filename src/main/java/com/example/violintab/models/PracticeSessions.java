package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "practice_sessions")
public class PracticeSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sheet_music_id", nullable = false)
    @NotNull(message = "Sheet music is mandatory")
    private SheetMusic sheetMusic;

    @NotNull(message = "Duration is mandatory")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @NotNull(message = "Date of session is mandatory")
    @PastOrPresent(message = "Session date cannot be in the future")
    @Column(name = "session_date", nullable = false)
    private LocalDate sessionDate;

    @NotNull(message = "Maximum tempo is mandatory")
    @Min(value = 20, message = "BPM must be at least 20")
    @Max(value = 400, message = "BPM must be at most 400")
    @Column(name = "max_bpm", nullable = false)
    private Integer maxBpm;
}
//aaaaaaaaaaaaa