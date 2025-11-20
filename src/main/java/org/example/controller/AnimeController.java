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
                if (name.equalsIgnoreCase("exit")) break;
                if (name.equalsIgnoreCase("list")) {
                    animeView.showAnimeList(animeService.getAnime());
                } else {
                    if (animeService.findAnime(name) != null) {
                        System.out.println("This anime already exists! (change/delete/exit)");
                        switch (scanner.nextLine()) {
                            case "exit":
                                break;
                            case "delete":
                                animeService.deleteAnime(name);
                                break;
                            case "change":
                                System.out.println("What exactly do you want to change? (title/genre/year/status): )");
                                switch (scanner.nextLine()) {
                                    case "title":
                                        System.out.println("Enter New Anime Title: ");
                                        String nt = scanner.nextLine();
                                        animeService.findAnime(name).setTitle(nt);
                                        break;
                                    case "genre":
                                        System.out.println("Enter New Anime Genre: ");
                                        String ng = scanner.nextLine();
                                        animeService.findAnime(name).setGenre(ng);
                                        break;
                                    case "year":
                                        System.out.println("Enter New Anime Year: ");
                                        int ny = scanner.nextInt();
                                        animeService.findAnime(name).setYear(ny);
                                        break;
                                    case "status":
                                        animeService.findAnime(name).setDone();
                                        System.out.println("Status changed!");
                                        break;
                                }
                        }
                    } else {
                        animeService.addAnime(name);
                        System.out.println("Anime added: " + name);
                    }
                }
            } catch (Exception e) {
                animeView.showMessage(e.getMessage());
            }

        }
    }
}
