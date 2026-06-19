package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.Email;

@Data
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Size(max = 100, message = "name must be less than 100 characters")
    @Column(nullable = false, name = "nombre")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Size(max = 150, message = "email must be less than 100 characters")
    @Column(nullable = false, unique = true, name = "email")
    @Email
    private String email;

    @NotBlank(message = "password is mandatory")
    @Size(max = 255, message = "password must be less than 100 characters")
    @Column(nullable = false, name = "password_hash")
    private String password;

    public enum Nivel {
        PRINCIPIANTE,
        INTERMEDIO,
        AVANZADO,
        PROFESSIONAL
    }

    @NotBlank(message = "nivel is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'PRINCIPIANTE'")
    private Nivel nivel;

    @NotBlank(message = "avatar is mandatory")
    @Size(max = 255, message = "avatar must be less than 100 characters")
    @Column(nullable = false, name = "avatar_url")
    private String avatar;

    @NotBlank(message = "hour zone is mandatory")
    @Size(max = 100, message = "hour zone must be less than 100 characters")
    @Column(nullable = false, name = "zona_horaria", columnDefinition = "VARCHAR(60) DEFAULT 'America/Mexico_City'")
    private String hourZone;

    @NotNull(message = "dark mode is mandatory")
    @Column(nullable = false, name = "modo_oscuro", columnDefinition = "BOOLEAN DEFAULT 0")
    private boolean darkMode;
}
