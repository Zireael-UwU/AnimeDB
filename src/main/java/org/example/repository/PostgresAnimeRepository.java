package org.example.repository;

import org.example.database.PostgresConnection;
import org.example.model.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresAnimeRepository {
    // Mutating
    public void save(Anime anime) {
        String sql = "INSERT INTO anime (title, genre, release_year, completed) VALUES (?,?,?,?)";

        try(Connection conn = PostgresConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, anime.getTitle());
            ps.setString(2, anime.getGenre());
            ps.setInt(3,anime.getYear());
            ps.setBoolean(4, anime.getDone());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                anime.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Anime> findAll() {
        List<Anime> animeList = new ArrayList<>();
        String sql = "SELECT * FROM anime";

        try(Connection conn = PostgresConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Anime a = new Anime();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setGenre(rs.getString("genre"));
                a.setYear(rs.getInt("release_year"));
                a.setDone(rs.getBoolean("completed"));
                animeList.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animeList;
    }

    // Querying
    public Anime findById(Anime anime) {
        Anime a = null;
        String sql = "SELECT * FROM anime WHERE title = ?";

        try(Connection conn = PostgresConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, anime.getTitle());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                a = new Anime();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setGenre(rs.getString("genre"));
                a.setYear(rs.getInt("release_year"));
                a.setDone(rs.getBoolean("completed"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    // Identifying
    public void deleteById(Anime anime) {
        String sql = "DELETE FROM anime WHERE id=?";

        try(Connection conn = PostgresConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, anime.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Mutating
    public void update(Anime anime) {
        String sql = "UPDATE anime SET title=?, genre=?, release_year=?, completed=? WHERE id=?";

        try(Connection conn = PostgresConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,anime.getTitle());
            ps.setString(2, anime.getGenre());
            ps.setInt(3,anime.getYear());
            ps.setBoolean(4, anime.getDone());
            ps.setInt(5, anime.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
