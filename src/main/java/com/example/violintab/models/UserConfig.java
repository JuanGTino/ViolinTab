package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Time;

@Data
@Entity
@Table(name = "configuracion_usuario")
public class UserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;

    @Column(name = "a4_hz", nullable = false, columnDefinition = "DOUBLE DEFAULT 440.0")
    private double frecuenciaLa;

    @Column(name = "metronomo_bpm_defecto", nullable = false, columnDefinition = "INT DEFAULT 120")
    private int metronomeBpmDefault;

    @Column(name = "recordatorio_activo", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean activeReminder;

    @Column(name = "hora_recordatorio" , nullable = true)
    private Time reminderTime;

    @Column(name = "dias_recordatorio", nullable = true, columnDefinition = "VARCHAR(255) DEFAULT '1111100'")
    private String reminderDays;

    public enum Nube{
        NINGUNA,
        GOOGLE_DRIVE,
        DROPBOX,
        ICLOUD
    }

    @Column(name = "nube_sync", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'NINGUNA'")
    @Enumerated(EnumType.STRING)
    private Nube nube;

}
