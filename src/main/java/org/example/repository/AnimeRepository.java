package org.example.repository;

import org.example.model.Anime;

import java.util.ArrayList;
import java.util.List;

// Слой-Репозиторий (persistence только сохранение/чтение объектов в памяти)
public class AnimeRepository {
    // Локальная переменная для хранения объектов в памяти
    private final List<Anime> animeList;

    // Конструктор
    public AnimeRepository() {
        animeList = new ArrayList<>();
    }

    // Сохранение объекта
    public void save(Anime anime) {
        animeList.add(anime);
    }

    // Удаление по названию
    public void deleteByTitle(String title) {
        animeList.remove(findByTitle(title));
    }

    // Возврат всего список объектов из БД (памяти)
    public List<Anime> findAll() {
        return new ArrayList<>(animeList);
    }

    // Поиск по названию реализован с помощью stream API
    // сортировка->переменная_объект->название_объекта->вернуть_совпадение->иначе_null
    public Anime findByTitle(String title) {
        return animeList.stream().filter(a -> a.getTitle().equals(title)).findFirst().orElse(null);
    }
}
