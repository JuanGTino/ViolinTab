package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "maintenance_logs")
public class MaintenanceLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Actions type is mandatory")
    @Size(max = 100, message = "Actions type must be less than 100 characters")
    @Column(name = "actions_type", nullable = false,  length = 100)
    private String actionsType;

    @Column(name = "date_performed", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime datePerformed;

    @Size(max = 255, message = "Notes must be less than 255 characters")
    @Column(length = 255)
    private String notes;
}
