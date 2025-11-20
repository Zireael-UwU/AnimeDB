package org.example.model;

public class Anime {
    private String title;
    private boolean done;

    public Anime(String title) {
        this.title = title;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDone() {
        this.done = true;
    }

    public String toString() {
        return (this.title + " " + (done ? "[✓]" : "[ ]"));
    }
}
