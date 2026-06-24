package com.example.violintab.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "sesiones_metronomo")
public class MetronomeSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;

    @NotNull(message = "bpm is mandatory")
    @Column(name = "bpm", nullable = false)
    private int bpm;

    public enum Subdivition {
        NEGRA,
        CORCHEA,
        TRESILLO,
        SEMICORCHEA,
    }
    @Column(name = "subdivicion", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'NEGRA'")
    @Enumerated(EnumType.STRING)
    private Subdivition subdivition;

    @Column(name = "compas", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT '4/4'")
    private String compass;

    @NotNull(message = "durationSeconds is mandatory")
    @Column(name = "duracion_seg", nullable = false)
    private int durationSeconds;

    @Column(name = "iniciada_en", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp startTime;

}
