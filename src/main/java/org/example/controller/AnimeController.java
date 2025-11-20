package org.example.controller;

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
            System.out.println("Enter anime name: ");
            String name = scanner.nextLine();

            try {
                switch (name) {
                    case "change":
                        System.out.println("What Anime do you want to change?: ");
                        String newName = scanner.nextLine();
                        if (newName.isEmpty()) {
                        }
                        animeService.findAnime(newName).setDone();
                        System.out.println(newName + " has been changed!");
                        break;
                    case "list":
                        animeView.showAnimeList(animeService.getAnime());
                        break;
                    default:
                        animeService.addAnime(name);
                        System.out.println("Anime added: " + name);
                        break;
                }
            } catch (Exception e) {
                animeView.showMessage(e.getMessage());
            }

        }
    }
}
