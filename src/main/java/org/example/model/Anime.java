package org.example.model;

// Слой-Модель (структура данных, POJO)
public class Anime {
    private int id;
    private String title;
    private boolean done;
    private String genre;
    private int year;

    // Конструктор, обязательное поле - название
    public Anime(String title) {
        this.title = title;
        this.done = false;
        this.genre = "";
        this.year = 0;
    }

    public Anime() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getDone() {
        return done;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    // Переопределение toString для корректного вывода
    public String toString() {
        return (this.title + " " + (done ? "[✓]" : "[ ]") + " " + genre + " " + (year != 0 ? year : ""));
    }
}
