package com.example.violintab.controllers;

import org.springframework.ui.Model;
import com.example.violintab.services.SheetMusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViolinController {
    private SheetMusicService sheetMusicService;

    public  ViolinController(SheetMusicService sheetMusicService) {
        this.sheetMusicService = sheetMusicService;
    }

//     @GetMapping("/songs")
//    public String showSongs(Model model) {
//         model.addAttribute("songs", sheetMusicService.getAllSongs());
//         return "songs"; // Asegúrate de tener un archivo songs.html en src/main
//     }
}
