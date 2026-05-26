package com.example.violintab.controllers;

import com.example.violintab.models.SheetMusic;
import com.example.violintab.services.SheetMusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partituras") // Ruta base de la API
public class SheetMusicRestController {

    private SheetMusicService service;

    public SheetMusicRestController(SheetMusicService service) {
        this.service = service;
    }

    // GET http://localhost:8080/api/partituras
    @GetMapping
    public List<SheetMusic> obtenerTodas() {
        return service.getAllSongs();
    }

    //POST
    // http://localhost:8080/api/partituras
    @PostMapping
    public SheetMusic crearPartitura(@RequestBody SheetMusic nuevaPartitura) {

        // Aquí deberías llamar a un método del servicio para guardar la nueva partitura
        return service.save(nuevaPartitura);
        //return null; // Reemplaza esto con la lógica real de guardado
    }
}