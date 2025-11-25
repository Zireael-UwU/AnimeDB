package org.example.controller;

import org.example.model.Anime;
import org.example.service.AnimeService;
import org.example.view.AnimeView;

// Слой-Контроллер (приём запросов, переадресация на сервис)
public class AnimeController {
    // Локальные переменные сервиса и представления
    private final AnimeService animeService;
    private final AnimeView animeView;

    // Контроллер с dependency injection
    public AnimeController(AnimeService animeService, AnimeView animeView) {
        this.animeService = animeService;
        this.animeView = animeView;
    }

    // Метод-Цикл интерпретации вводимых пользователем данных
    public void start() {
        animeView.showHeader();
        // Цикл бесконечный, выход с помощью введения exit
        while (true) {
            try {
                String animeName = animeView.showSentence();
                // Реализация выхода из цикла
                if (animeName.equalsIgnoreCase("exit")) {break;}
                // Реализация вывода полного списка объектов
                if (animeName.equalsIgnoreCase("list")) {
                    animeView.showAnimeList(animeService.getAnime());
                } else {
                    // Проверка по полученному названию, выбор соответствующего алгоритма сервиса
                    Anime anime = animeService.findByName(animeName);
                    if (anime != null) {
                        String action = animeView.showMenu(animeName);
                        // Реализация меню выбора доступных действий для существующего объекта
                        switch (action) {
                            case "title" -> {
                                // Изменение названия
                                String s1 = animeView.showPattern(action);
                                animeService.updateTitle(s1,anime);
                                animeView.showChange(action);
                            }
                            case "genre" -> {
                                // Изменение жанра
                                String s2 = animeView.showPattern(action);
                                animeService.updateGenre(s2,anime);
                                animeView.showChange(action);
                            }
                            case "year" -> {
                                // Изменение года
                                String s3 = animeView.showPattern(action);
                                animeService.updateYear(Integer.parseInt(s3),anime);
                                animeView.showChange(action);
                            }
                            case "status" -> {
                                // Изменение статуса на "просмотрено"
                                animeService.updateStatus(anime);
                                animeView.showChange(action);
                            }
                            case "delete" -> {
                                // Удаление объекта из памяти
                                animeService.deleteAnime(animeName);
                                animeView.showDelete(animeName);
                            }
                        }
                    } else {
                        // Добавление нового объекта в память
                        animeService.addAnime(new Anime(animeName));
                        animeView.showAdd(animeName);
                    }
                }
            } catch (Exception e) {
                animeView.showMessage(e.getMessage());
            }

        }
    }
}
