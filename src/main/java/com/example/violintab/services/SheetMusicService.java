package com.example.violintab.services;

import org.springframework.stereotype.Service;
import com.example.violintab.repositories.SheetMusicRepository;
import com.example.violintab.models.SheetMusic;

import java.util.List;


@Service
public class SheetMusicService {

    private SheetMusicRepository sheetMusicRepository;

    public List<SheetMusic> getAllSongs() {
        return sheetMusicRepository.findAll();
    }

}
