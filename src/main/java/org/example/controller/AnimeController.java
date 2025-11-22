package org.example.controller;

import org.example.model.Anime;
import org.example.service.AnimeService;
import org.example.view.AnimeView;

import java.util.Scanner;

public class AnimeController {
    private final AnimeService animeService;
    private final AnimeView animeView;

    public AnimeController(AnimeService animeService, AnimeView animeView) {
        this.animeService = animeService;
        this.animeView = animeView;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        animeView.showHeader();
        while (true) {
            animeView.showSentence();
            String name = scanner.nextLine();

            try {
                if (name.equalsIgnoreCase("exit")) break;
                if (name.equalsIgnoreCase("list")) {
                    animeView.showAnimeList(animeService.getAnime());
                } else {
                    Anime anime = animeService.findByName(name);
                    if (anime != null) {
                        animeView.showMenu(name);
                        String scan = scanner.nextLine();
                        switch (scan) {
                            case "delete" -> {
                                animeService.deleteAnime(anime);
                                animeView.showDelete(name);
                            }
                            case "status" -> {
                                animeService.updateAnime(scan, anime, null);
                                animeView.showChange(scan);
                            }
                            default -> {
                                animeView.showPattern(scan);
                                animeService.updateAnime(scan, anime, scanner.nextLine());
                                animeView.showChange(scan);
                            }
                        }
                    } else {
                        animeService.addAnime(new Anime(name));
                        animeView.showAdd(name);
                    }
                }
            } catch (Exception e) {
                animeView.showMessage(e.getMessage());
            }

        }
    }
}
