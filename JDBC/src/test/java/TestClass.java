import connection.ConnectionPool;
import dao.DescriptionDAO;
import dao.DirectorDAO;
import dao.MovieDAO;
import entity.Description;
import entity.Director;
import entity.Movie;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by win10 on 04.10.2016.
 */
public class TestClass {

    private static MovieDAO movieDAO;
    private static DirectorDAO directorDAO;
    private static DescriptionDAO descriptionDAO;

    @BeforeClass
    public static void init() {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
        movieDAO = new MovieDAO(connectionPool);
        directorDAO = new DirectorDAO(connectionPool);
        descriptionDAO = new DescriptionDAO(connectionPool);
    }

    @Test
    public void addTest() {
        int id = 100;

        Description sourceDescription = new Description(id, "testTitle", "testContent");
        Director sourceDirector = new Director(id, "testName", "testSurname");
        Movie sourceMovie = new Movie(id, "testMovieName", 7200, 2016, id, id);

        boolean directorAdd = directorDAO.add(sourceDirector);
        Assert.assertEquals(directorAdd, true);

        boolean descriptionAdd = descriptionDAO.add(sourceDescription);
        Assert.assertEquals(descriptionAdd, true);

        boolean movieAdd = movieDAO.add(sourceMovie);
        Assert.assertEquals(movieAdd, true);

        Description destinationDescription = descriptionDAO.getById(id);
        Director destinationDirector = directorDAO.getById(id);
        Movie destinationMovie = movieDAO.getById(id);

        Assert.assertEquals(sourceMovie, destinationMovie);
        Assert.assertEquals(sourceDescription, destinationDescription);
        Assert.assertEquals(sourceDirector, destinationDirector);

        boolean movieDelete = movieDAO.deleteById(id);
        Assert.assertEquals(movieDelete, true);

        boolean descriptionDelete = descriptionDAO.deleteById(id);
        Assert.assertEquals(descriptionDelete, true);

        boolean directorDelete = directorDAO.deleteById(id);
        Assert.assertEquals(directorDelete, true);
    }

    @Test
    public void updateTest() {
        int id = 100;

        Description sourceDescription = new Description(id, "testTitle", "testContent");
        Director sourceDirector = new Director(id, "testName", "testSurname");
        Movie sourceMovie = new Movie(id, "testMovieName", 7200, 2016, id, id);

        boolean directorAdd = directorDAO.add(sourceDirector);
        Assert.assertEquals(directorAdd, true);

        boolean descriptionAdd = descriptionDAO.add(sourceDescription);
        Assert.assertEquals(descriptionAdd, true);

        boolean movieAdd = movieDAO.add(sourceMovie);
        Assert.assertEquals(movieAdd, true);

        sourceMovie = movieDAO.getById(id);
        sourceDescription = descriptionDAO.getById(id);
        sourceDirector = directorDAO.getById(id);

        sourceMovie.setName("update");
        sourceDescription.setTitle("update");
        sourceDirector.setName("update");

        boolean movieUpdate = movieDAO.update(sourceMovie);
        Assert.assertEquals(movieUpdate, true);

        boolean descriptionUpdate = descriptionDAO.update(sourceDescription);
        Assert.assertEquals(descriptionUpdate, true);

        boolean directorUpdate = directorDAO.update(sourceDirector);
        Assert.assertEquals(directorUpdate, true);

        Description destinationDescription = descriptionDAO.getById(id);
        Assert.assertEquals(sourceDescription, destinationDescription);

        Director destinationDirector = directorDAO.getById(id);
        Assert.assertEquals(sourceDirector, destinationDirector);

        Movie destinationMovie = movieDAO.getById(id);
        Assert.assertEquals(sourceMovie, destinationMovie);

        boolean movieDelete = movieDAO.deleteById(id);
        Assert.assertEquals(movieDelete, true);

        boolean descriptionDelete = descriptionDAO.deleteById(id);
        Assert.assertEquals(descriptionDelete, true);

        boolean directorDelete = directorDAO.deleteById(id);
        Assert.assertEquals(directorDelete, true);

    }



}
