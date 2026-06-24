package com.example.violintab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Size(max = 150, message = "name must be less than 150 characters")
    @Column(nullable = false, length = 150, name = "name")
    private String name;

    @Size(max = 150, message = "lastName must be less than 150 characters")
    @Column(length = 150, name = "last_name")
    private String lastName;

    @Size(max = 50, message = "age must be less than 50 characters")
    @Column(length = 50, name = "epoca")
    private String age;

    @Size(max = 80, message = "country must be less than 80 characters")
    @Column(length = 80, name = "pais")
    private String country;

    @Column(name = "anio_nac")
    private Integer yearBirth;

    @Column(name = "anio_muerte")
    private Integer yearDeath;
}
