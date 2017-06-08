package dao;

import connection.ConnectionPool;
import connection.ConnectionWrapper;
import entity.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win10 on 08.10.2016.
 */
public class DirectorDAO extends AbstractDAO<Director> {

    public DirectorDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Director> getAll() {
        String query = "SELECT * FROM director;";
        List<Director> directors = null;
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement = connectionWrapper.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            directors = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("director_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");

                directors.add(new Director(id, name, surname));
            }
        } catch (SQLException e) {
            System.out.println("Error in getAll(Director)" + e.getMessage());
        }

        return directors;
    }

    @Override
    public Director getById(int id) {
        Director director = null;
        String query = "SELECT * FROM director WHERE director_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            director = new Director(id, name, surname);
        } catch (SQLException e) {
            System.out.println("Error in getById(Director)");
            e.printStackTrace();
        }

        return director;
    }

    @Override
    public boolean add(Director director) {
        String query = "INSERT INTO director(director_id, name, surname) VALUES (?,?,?);";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, director.getId());
            preparedStatement.setString(2, director.getName());
            preparedStatement.setString(3, director.getSurname());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in add(Director)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Director director) {
        String query = "UPDATE director SET name = ?, surname = ? WHERE director_id = ?;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(3, director.getId());
            preparedStatement.setString(1, director.getName());
            preparedStatement.setString(2, director.getSurname());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in update(Director)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM director WHERE director_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteByID(Director)" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public int maxId() {
        int result = 0;
        String query = "SELECT MAX(director_id) FROM director;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement= connectionWrapper.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            result = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error in maxId(Director)" + e.getMessage());
        }

        return result;
    }
}
