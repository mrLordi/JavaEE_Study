package main.java.dao;

import main.java.connection.ConnectionPool;
import main.java.connection.ConnectionWrapper;
import main.java.entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win10 on 03.10.2016.
 */
public class MovieDAO extends AbstractDAO<Movie> {

    public MovieDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Movie> getAll() {
        String query = "SELECT * FROM movie;";
        List<Movie> movies = null;
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement = connectionWrapper.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            movies = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("movie_id");
                String name = resultSet.getString("name");
                int duration = resultSet.getInt("duration");
                int year = resultSet.getInt("year");
                int descriptionId = resultSet.getInt("description_id");
                int directorId = resultSet.getInt("director_id");

                movies.add(new Movie(id, name, duration, year, descriptionId, directorId));
            }
        } catch (SQLException e) {
            System.out.println("Error in getAll(Movie)" + e.getMessage());
        }

        return movies;
    }

    @Override
    public Movie getById(int id) {
        Movie movie = null;
        String query = "SELECT * FROM movie WHERE movie_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            int duration = resultSet.getInt("duration");
            int year = resultSet.getInt("year");
            int descriptionId = resultSet.getInt("description_id");
            int directorId = resultSet.getInt("director_id");

            movie = new Movie(id, name, duration, year, descriptionId, directorId);
        } catch (SQLException e) {
            System.out.println("Error in getById(Movie)");
            e.printStackTrace();
        }

        return movie;
    }

    @Override
    public synchronized boolean add(Movie movie) {
        String query = "INSERT INTO movie(movie_id, name, duration, year, description_id, " +
                "director_id) VALUES (?,?,?,?,?,?);";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, movie.getId());
            preparedStatement.setString(2, movie.getName());
            preparedStatement.setInt(3, movie.getDuration());
            preparedStatement.setInt(4, movie.getYear());
            preparedStatement.setInt(5, movie.getDescriptionId());
            preparedStatement.setInt(6, movie.getDirectorId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in add(Movie)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean update(Movie movie) {
        String query = "UPDATE movie SET name = ?, duration = ?, year = ?, description_id = ?," +
                "director_id = ? WHERE movie_id = ?;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getDuration());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.setInt(4, movie.getDescriptionId());
            preparedStatement.setInt(5, movie.getDirectorId());
            preparedStatement.setInt(6, movie.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in update(Movie)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean deleteById(int id) {
        String query = "DELETE FROM movie WHERE movie_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteByID(Movie)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public synchronized int maxId() {
        int result = 0;
        String query = "SELECT MAX(movie_id) FROM movie;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement= connectionWrapper.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            result = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error in maxId(Movie)" + e.getMessage());
        }

        return result;
    }
}
