package main.java.dao;

import main.java.connection.ConnectionPool;
import main.java.connection.ConnectionWrapper;
import main.java.entity.Description;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win10 on 07.10.2016.
 */
public class DescriptionDAO extends AbstractDAO<Description> {

    public DescriptionDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Description> getAll() {
        String query = "SELECT * FROM description;";
        List<Description> descriptions = null;
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement = connectionWrapper.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            descriptions = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("description_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");

                descriptions.add(new Description(id, title, content));
            }
        } catch (SQLException e) {
            System.out.println("Error in getAll(Description)" + e.getMessage());
        }

        return descriptions;
    }

    @Override
    public Description getById(int id) {
        Description description = null;
        String query = "SELECT * FROM description WHERE description_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String title = resultSet.getString("title");
            String content = resultSet.getString("content");

            description = new Description(id, title, content);
        } catch (SQLException e) {
            System.out.println("Error in getById(Description)");
            e.printStackTrace();
        }

        return description;
    }

    @Override
    public synchronized boolean add(Description description) {
        String query = "INSERT INTO description(description_id, title, content) VALUES (?,?,?);";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, description.getId());
            preparedStatement.setString(2, description.getTitle());
            preparedStatement.setString(3, description.getContent());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in add(Description)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean update(Description description) {
        String query = "UPDATE description SET title = ?, content = ? WHERE description_id = ?;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(3, description.getId());
            preparedStatement.setString(1, description.getTitle());
            preparedStatement.setString(2, description.getContent());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in update(Description)" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean deleteById(int id) {
        String query = "DELETE FROM description WHERE description_id = ?;";
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection();
            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteByID(Description)" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public synchronized int maxId() {
        int result = 0;
        String query = "SELECT MAX(description_id) FROM description;";
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnection();
             Statement statement= connectionWrapper.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            result = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error in maxId(Description)" + e.getMessage());
        }

        return result;
    }

}
