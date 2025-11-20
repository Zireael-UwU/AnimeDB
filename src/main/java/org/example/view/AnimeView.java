package org.example.view;

import org.example.model.Anime;

import java.util.List;

public class AnimeView {
    public void showHeader() {
        System.out.println("This is a simple Anime list. Type 'list' to view all the anime list.");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showAnimeList(List<Anime> animeList) {
        if (animeList == null) {
            System.out.println("There is no anime to show.");
        } else {
            for (Anime anime : animeList) {
                System.out.println(anime);
            }
        }
    }
}
