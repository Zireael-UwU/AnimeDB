package org.example.service;

import org.example.model.Anime;
import org.example.repository.AnimeRepository;

import java.util.List;

public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAnime() {
        return animeRepository.findAll();
    }

    public void addAnime(String animeName) {
        animeRepository.save(new Anime(animeName));
    }

    public Anime findAnime(String animeName) {
        return animeRepository.findById(animeName);
    }

    public void deleteAnime(String animeName) {
        animeRepository.delete(animeName);
    }
}
