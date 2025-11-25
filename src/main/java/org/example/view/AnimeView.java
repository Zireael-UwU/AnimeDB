package org.example.view;

import org.example.model.Anime;

import java.util.List;
import java.util.Scanner;

// Слой-Визуализация (UI для взаимодействия с пользователем)
public class AnimeView {
    Scanner scanner = new Scanner(System.in);

    // Шапка с основной информацией
    public void showHeader() {
        System.out.println("This is a simple Anime list. \nEnter 'list' to view all the anime list. \nEnter 'exit' to exit. \n");
    }

    // Отображение текста
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Вывод списка объектов
    public void showAnimeList(List<Anime> animeList) {
        if (animeList == null) {
            System.out.println("There is no anime to show.");
        } else {
            for (Anime anime : animeList) {
                System.out.println(anime);
            }
        }
    }

    // Получение основной информации от пользователя (название объекта)
    public String showSentence() {
        System.out.print("Enter anime name: ");
        return scanner.nextLine();
    }

    // Выбор из меню действий для уже существующего объекта
    public String showMenu(String s) {
        System.out.print("Anime \"" + s + "\" already exists! You can change it's conditions! \n(title/genre/year/status/delete): ");
        return scanner.nextLine();
    }

    // Получение нового, измененного параметра
    public String showPattern(String s) {
        System.out.print("Enter New Anime " + s + ": ");
        return scanner.nextLine();
    }

    // Отображение успеха изменения данных
    public void showChange(String s) {
        System.out.println(s + " changed!");
    }

    // Отображение успеха добавления объекта
    public void showAdd(String s) {
        System.out.println("Anime added: " + s);
    }

    // Отображение успеха удаления объекта
    public void showDelete(String s) {
        System.out.println(s + " was deleted T_T");
    }
}
