import connection.ConnectionPool;
import dao.DescriptionDAO;
import dao.DirectorDAO;
import dao.MovieDAO;
import entity.Description;
import entity.Director;
import entity.Movie;

/**
 * Created by win10 on 03.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
        DirectorDAO directorDAO = new DirectorDAO(connectionPool);
        directorDAO.add(new Director(1, "firstDirector", "firstDirector"));
        directorDAO.add(new Director(2, "secondDirector", "secondDirector"));
        directorDAO.add(new Director(3, "thirdDirector", "thirdDirector"));

        DescriptionDAO descriptionDAO = new DescriptionDAO(connectionPool);
        descriptionDAO.add(new Description(1, "firstTitle", "firstContent"));
        descriptionDAO.add(new Description(2, "secondTitle", "secondContent"));
        descriptionDAO.add(new Description(3, "thirdTitle", "thirdContent"));
        descriptionDAO.add(new Description(4, "fourthTitle", "fourthContent"));
        descriptionDAO.add(new Description(5, "fifthTitle", "fifthContent"));
        descriptionDAO.add(new Description(6, "sixthTitle", "sixthContent"));

        MovieDAO movieDAO = new MovieDAO(connectionPool);
        movieDAO.add(new Movie(1, "firstMovie", 7200, 2016, 1, 1));
        movieDAO.add(new Movie(2, "secondMovie", 7200, 2016, 2, 1));
        movieDAO.add(new Movie(3, "thirdMovie", 7200, 2016, 3, 1));
        movieDAO.add(new Movie(4, "firstMovie", 7200, 2016, 4, 2));
        movieDAO.add(new Movie(5, "secondMovie", 7200, 2016, 5, 2));
        movieDAO.add(new Movie(6, "thirdMovie", 7200, 2016, 6, 3));
    }
}
