package com.example.violintab.services;

import org.springframework.stereotype.Service;
import com.example.violintab.repositories.SheetMusicRepository;
import com.example.violintab.models.SheetMusic;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SheetMusicService {

    private SheetMusicRepository sheetMusicRepository;

    public SheetMusicService(SheetMusicRepository sheetMusicRepository) {
        this.sheetMusicRepository = sheetMusicRepository;
    }

//    public List<SheetMusic> getAllSongs() {
//        return sheetMusicRepository.findAll().stream()
//                .filter(s -> s.getStatus() != SheetMusic.Status.eliminado)
//                .collect(Collectors.toList());
//    }


    //POST
    public SheetMusic save(SheetMusic sheetMusic) {
        return sheetMusicRepository.save(sheetMusic);
    }

}
