package org.example;

import org.example.controller.AnimeController;
import org.example.repository.AnimeRepository;
import org.example.service.AnimeService;
import org.example.view.AnimeView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        new AnimeController(new AnimeService(new AnimeRepository()), new AnimeView()).start();
    }
}