package com.example.violintab.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "configuracion_usuario")
public class TunerSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;

    @Column(name = "iniciada_en", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date startTime;

    @Column(name = "finalizada_en", nullable = true)
    private Date endTime;

    @Column(name = "a4_hz_usado" , nullable = false, columnDefinition = "DOUBLE DEFAULT 440.0")
    private double frequencyLaUsed;

    @NotBlank(message = "notesUsed is mandatory")
    @Column(name = "notas_detectadas",  nullable = false)
    private String notesUsed;
}
