package org.example.repository;

import org.example.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeRepository {
    private final List<Anime> animeList;

    public AnimeRepository() {
        animeList = new ArrayList<>();
    }

    public void save(Anime anime) {
        animeList.add(anime);
    }

    public void delete(Anime anime) {
        animeList.remove(anime);
    }

    public List<Anime> findAll() {
        return new ArrayList<>(animeList);
    }

    public Anime find(Anime anime) {
        Anime n = null;
        for (Anime a : animeList) {
            if (a.getTitle().equals(anime.getTitle())) {
                n = a;
                break;
            }
        }
        return n;
    }
}
