
package wsClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MovieWS", targetNamespace = "http://wsServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MovieWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addMovie", targetNamespace = "http://wsServices/", className = "wsClient.AddMovie")
    @ResponseWrapper(localName = "addMovieResponse", targetNamespace = "http://wsServices/", className = "wsClient.AddMovieResponse")
    public void addMovie(
        @WebParam(name = "arg0", targetNamespace = "")
        Movie arg0);

    /**
     * 
     * @return
     *     returns java.util.List<wsClient.Movie>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllMovies", targetNamespace = "http://wsServices/", className = "wsClient.GetAllMovies")
    @ResponseWrapper(localName = "getAllMoviesResponse", targetNamespace = "http://wsServices/", className = "wsClient.GetAllMoviesResponse")
    public List<Movie> getAllMovies();

    /**
     * 
     * @param arg0
     * @return
     *     returns wsClient.Movie
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMovieById", targetNamespace = "http://wsServices/", className = "wsClient.GetMovieById")
    @ResponseWrapper(localName = "getMovieByIdResponse", targetNamespace = "http://wsServices/", className = "wsClient.GetMovieByIdResponse")
    public Movie getMovieById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateMovie", targetNamespace = "http://wsServices/", className = "wsClient.UpdateMovie")
    @ResponseWrapper(localName = "updateMovieResponse", targetNamespace = "http://wsServices/", className = "wsClient.UpdateMovieResponse")
    public void updateMovie(
        @WebParam(name = "arg0", targetNamespace = "")
        Movie arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteMovie", targetNamespace = "http://wsServices/", className = "wsClient.DeleteMovie")
    @ResponseWrapper(localName = "deleteMovieResponse", targetNamespace = "http://wsServices/", className = "wsClient.DeleteMovieResponse")
    public void deleteMovie(
        @WebParam(name = "arg0", targetNamespace = "")
        Movie arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteMovieById", targetNamespace = "http://wsServices/", className = "wsClient.DeleteMovieById")
    @ResponseWrapper(localName = "deleteMovieByIdResponse", targetNamespace = "http://wsServices/", className = "wsClient.DeleteMovieByIdResponse")
    public void deleteMovieById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}