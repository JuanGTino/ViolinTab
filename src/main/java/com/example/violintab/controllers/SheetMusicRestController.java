package com.example.violintab.controllers;

import com.example.violintab.models.SheetMusic;
import com.example.violintab.services.SheetMusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partituras") // Ruta base de la API
public class SheetMusicRestController {

    private SheetMusicService service;

    // GET http://localhost:8080/api/partituras
    @GetMapping
    public List<SheetMusic> obtenerTodas() {
        return service.getAllSongs();
    }
}