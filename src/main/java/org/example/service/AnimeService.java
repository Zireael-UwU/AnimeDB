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

    public void addAnime(Anime anime) {
        animeRepository.save(anime);
    }

    public Anime findByName(String animeName) {
        return animeRepository.find(new Anime(animeName));
    }

    public void deleteAnime(Anime anime) {
        animeRepository.delete(anime);
    }

    public void updateAnime(String s, Anime anime, String feature) {
        switch (s) {
            case "title" -> anime.setName(feature);
            case "genre" -> anime.setGenre(feature);
            case "year" -> anime.setYear(Integer.parseInt(feature));
            case "status" -> anime.setDone();
        }
    }
}
