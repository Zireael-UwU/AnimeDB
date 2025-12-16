package org.example;

import org.example.controller.AnimeController;
import org.example.repository.PostgresAnimeRepository;
import org.example.service.AnimeService;
import org.example.view.AnimeView;

// Запуск приложения
public class Main {
    public static void main(String[] args) {
        new AnimeController(new AnimeService(new PostgresAnimeRepository()), new AnimeView()).start();
    }
}