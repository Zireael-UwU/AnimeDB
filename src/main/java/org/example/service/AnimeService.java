package org.example.service;

import org.example.model.Anime;
import org.example.repository.AnimeRepository;
import org.example.repository.PostgresAnimeRepository;

import java.util.List;

// Слой-Сервис (бизнес логика, операции пока без валидации)
public class AnimeService {
    // Локальная переменная репозитория
    private final PostgresAnimeRepository animeRepository;

    // Контроллер с dependency injection
    public AnimeService(PostgresAnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAnime() {
        return animeRepository.findAll();
    }

    public void addAnime(Anime anime) {
        animeRepository.save(anime);
    }

    public Anime findByName(String title) {
        return animeRepository.findByTitle(title);
    }

    public void deleteAnime(String title) {
        animeRepository.deleteByTitle(title);
    }

    public void updateTitle(String s, Anime anime) {
        anime.setTitle(s);
        animeRepository.update(anime);
    }

    public void updateGenre(String s, Anime anime) {
        anime.setGenre(s);
        animeRepository.update(anime);
    }

    public void updateYear(int i, Anime anime) {
        anime.setYear(i);
        animeRepository.update(anime);
    }

    public void updateStatus(Anime anime) {
        anime.setDone(!anime.getDone());
        animeRepository.update(anime);
    }
}
