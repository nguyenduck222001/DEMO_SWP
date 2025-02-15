/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Movie;
import dal.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DBContext {

    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movies";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set start date as the second parameter

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setMovieID(rs.getInt("MovieID"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setGenre(rs.getString("Genre"));
                    movie.setSummary(rs.getString("Summary"));
                    movie.setDuration(rs.getInt("Duration"));
                    movie.setReleaseDate(rs.getDate("ReleaseDate"));
                    movie.setTrailerURL(rs.getString("TrailerURL"));
                    movie.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    movie.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    movie.setImageURL(rs.getString("ImageURL"));
                    movie.setStatus(rs.getString("Status"));
                    movies.add(movie);
                }
            }

            return movies;
        }
    }

    public List<Movie> getNowShowingMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movies WHERE Status = N'Đang chiếu'";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setMovieID(rs.getInt("MovieID"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setGenre(rs.getString("Genre"));
                    movie.setSummary(rs.getString("Summary"));
                    movie.setDuration(rs.getInt("Duration"));
                    movie.setReleaseDate(rs.getDate("ReleaseDate"));
                    movie.setTrailerURL(rs.getString("TrailerURL"));
                    movie.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    movie.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    movie.setImageURL(rs.getString("ImageURL"));
                    movie.setStatus(rs.getString("Status"));
                    movies.add(movie);
                }
            }

            return movies;
        }
    }

    public List<Movie> getComingSoonMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movies WHERE Status = N'Sắp chiếu'";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setMovieID(rs.getInt("MovieID"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setGenre(rs.getString("Genre"));
                    movie.setSummary(rs.getString("Summary"));
                    movie.setDuration(rs.getInt("Duration"));
                    movie.setReleaseDate(rs.getDate("ReleaseDate"));
                    movie.setTrailerURL(rs.getString("TrailerURL"));
                    movie.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    movie.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    movie.setImageURL(rs.getString("ImageURL"));
                    movie.setStatus(rs.getString("Status"));
                    movies.add(movie);
                }
            }

            return movies;
        }
    }

    public Movie getMoviesByID(int movieID) {
        String sql = "SELECT * FROM Movies WHERE MovieID = ?";
        Movie movie = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, movieID);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    movie = new Movie();
                    movie.setMovieID(rs.getInt("MovieID"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setGenre(rs.getString("Genre"));
                    movie.setSummary(rs.getString("Summary"));
                    movie.setDuration(rs.getInt("Duration"));
                    movie.setReleaseDate(rs.getDate("ReleaseDate"));
                    movie.setTrailerURL(rs.getString("TrailerURL"));
                    movie.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    movie.setUpdatedAt(rs.getTimestamp("UpdatedAt"));
                    movie.setImageURL(rs.getString("ImageURL"));
                    movie.setStatus(rs.getString("Status"));
                }
            }
        } catch (SQLException e) {
            // In ra thông báo lỗi để debug
            System.err.println("Lỗi khi truy vấn phim theo ID: " + e.getMessage());
            e.printStackTrace();
        }

        return movie;
    }
}
