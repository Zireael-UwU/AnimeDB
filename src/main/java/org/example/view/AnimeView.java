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

    public void showSentence() {
        System.out.print("Enter anime name: ");
    }

    public void showMenu(String s) {
        System.out.print("Anime \"" + s + "\" already exists! You can change it's conditions! \n(title/genre/year/status/delete): ");
    }

    public void showPattern(String s) {
        System.out.print("Enter New Anime " + s + ": ");
    }

    public void showChange(String s) {
        System.out.println(s + " changed!");
    }

    public void showAdd(String s) {
        System.out.println("Anime added: " + s);
    }

    public void showDelete(String s) {
        System.out.println(s + " was deleted T_T");
    }
}
