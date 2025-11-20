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

    public List<Anime> findAll() {
        return new ArrayList<>(animeList);
    }

    public void delete(String id) {
        animeList.remove(findById(id));
    }

    public Anime findById(String id) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equals(id)) {
                return anime;
            }
        }
        return null;
    }
}
