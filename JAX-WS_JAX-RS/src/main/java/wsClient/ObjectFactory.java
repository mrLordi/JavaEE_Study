
package wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Description_QNAME = new QName("http://wsServices/", "description");
    private final static QName _DeleteMovieResponse_QNAME = new QName("http://wsServices/", "deleteMovieResponse");
    private final static QName _UpdateMovieResponse_QNAME = new QName("http://wsServices/", "updateMovieResponse");
    private final static QName _GetMovieById_QNAME = new QName("http://wsServices/", "getMovieById");
    private final static QName _GetAllMoviesResponse_QNAME = new QName("http://wsServices/", "getAllMoviesResponse");
    private final static QName _Movie_QNAME = new QName("http://wsServices/", "movie");
    private final static QName _DeleteMovie_QNAME = new QName("http://wsServices/", "deleteMovie");
    private final static QName _Director_QNAME = new QName("http://wsServices/", "director");
    private final static QName _Producer_QNAME = new QName("http://wsServices/", "producer");
    private final static QName _AddMovie_QNAME = new QName("http://wsServices/", "addMovie");
    private final static QName _AddMovieResponse_QNAME = new QName("http://wsServices/", "addMovieResponse");
    private final static QName _GetMovieByIdResponse_QNAME = new QName("http://wsServices/", "getMovieByIdResponse");
    private final static QName _GetAllMovies_QNAME = new QName("http://wsServices/", "getAllMovies");
    private final static QName _UpdateMovie_QNAME = new QName("http://wsServices/", "updateMovie");
    private final static QName _DeleteMovieByIdResponse_QNAME = new QName("http://wsServices/", "deleteMovieByIdResponse");
    private final static QName _DeleteMovieById_QNAME = new QName("http://wsServices/", "deleteMovieById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateMovieResponse }
     * 
     */
    public UpdateMovieResponse createUpdateMovieResponse() {
        return new UpdateMovieResponse();
    }

    /**
     * Create an instance of {@link GetMovieById }
     * 
     */
    public GetMovieById createGetMovieById() {
        return new GetMovieById();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link GetAllMoviesResponse }
     * 
     */
    public GetAllMoviesResponse createGetAllMoviesResponse() {
        return new GetAllMoviesResponse();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link DeleteMovie }
     * 
     */
    public DeleteMovie createDeleteMovie() {
        return new DeleteMovie();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link DeleteMovieResponse }
     * 
     */
    public DeleteMovieResponse createDeleteMovieResponse() {
        return new DeleteMovieResponse();
    }

    /**
     * Create an instance of {@link DeleteMovieByIdResponse }
     * 
     */
    public DeleteMovieByIdResponse createDeleteMovieByIdResponse() {
        return new DeleteMovieByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateMovie }
     * 
     */
    public UpdateMovie createUpdateMovie() {
        return new UpdateMovie();
    }

    /**
     * Create an instance of {@link DeleteMovieById }
     * 
     */
    public DeleteMovieById createDeleteMovieById() {
        return new DeleteMovieById();
    }

    /**
     * Create an instance of {@link AddMovie }
     * 
     */
    public AddMovie createAddMovie() {
        return new AddMovie();
    }

    /**
     * Create an instance of {@link AddMovieResponse }
     * 
     */
    public AddMovieResponse createAddMovieResponse() {
        return new AddMovieResponse();
    }

    /**
     * Create an instance of {@link Producer }
     * 
     */
    public Producer createProducer() {
        return new Producer();
    }

    /**
     * Create an instance of {@link GetAllMovies }
     * 
     */
    public GetAllMovies createGetAllMovies() {
        return new GetAllMovies();
    }

    /**
     * Create an instance of {@link GetMovieByIdResponse }
     * 
     */
    public GetMovieByIdResponse createGetMovieByIdResponse() {
        return new GetMovieByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Description }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "description")
    public JAXBElement<Description> createDescription(Description value) {
        return new JAXBElement<Description>(_Description_QNAME, Description.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "deleteMovieResponse")
    public JAXBElement<DeleteMovieResponse> createDeleteMovieResponse(DeleteMovieResponse value) {
        return new JAXBElement<DeleteMovieResponse>(_DeleteMovieResponse_QNAME, DeleteMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateMovieResponse")
    public JAXBElement<UpdateMovieResponse> createUpdateMovieResponse(UpdateMovieResponse value) {
        return new JAXBElement<UpdateMovieResponse>(_UpdateMovieResponse_QNAME, UpdateMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getMovieById")
    public JAXBElement<GetMovieById> createGetMovieById(GetMovieById value) {
        return new JAXBElement<GetMovieById>(_GetMovieById_QNAME, GetMovieById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getAllMoviesResponse")
    public JAXBElement<GetAllMoviesResponse> createGetAllMoviesResponse(GetAllMoviesResponse value) {
        return new JAXBElement<GetAllMoviesResponse>(_GetAllMoviesResponse_QNAME, GetAllMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "deleteMovie")
    public JAXBElement<DeleteMovie> createDeleteMovie(DeleteMovie value) {
        return new JAXBElement<DeleteMovie>(_DeleteMovie_QNAME, DeleteMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Director }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "director")
    public JAXBElement<Director> createDirector(Director value) {
        return new JAXBElement<Director>(_Director_QNAME, Director.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Producer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "producer")
    public JAXBElement<Producer> createProducer(Producer value) {
        return new JAXBElement<Producer>(_Producer_QNAME, Producer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "addMovie")
    public JAXBElement<AddMovie> createAddMovie(AddMovie value) {
        return new JAXBElement<AddMovie>(_AddMovie_QNAME, AddMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "addMovieResponse")
    public JAXBElement<AddMovieResponse> createAddMovieResponse(AddMovieResponse value) {
        return new JAXBElement<AddMovieResponse>(_AddMovieResponse_QNAME, AddMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getMovieByIdResponse")
    public JAXBElement<GetMovieByIdResponse> createGetMovieByIdResponse(GetMovieByIdResponse value) {
        return new JAXBElement<GetMovieByIdResponse>(_GetMovieByIdResponse_QNAME, GetMovieByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getAllMovies")
    public JAXBElement<GetAllMovies> createGetAllMovies(GetAllMovies value) {
        return new JAXBElement<GetAllMovies>(_GetAllMovies_QNAME, GetAllMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateMovie")
    public JAXBElement<UpdateMovie> createUpdateMovie(UpdateMovie value) {
        return new JAXBElement<UpdateMovie>(_UpdateMovie_QNAME, UpdateMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "deleteMovieByIdResponse")
    public JAXBElement<DeleteMovieByIdResponse> createDeleteMovieByIdResponse(DeleteMovieByIdResponse value) {
        return new JAXBElement<DeleteMovieByIdResponse>(_DeleteMovieByIdResponse_QNAME, DeleteMovieByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "deleteMovieById")
    public JAXBElement<DeleteMovieById> createDeleteMovieById(DeleteMovieById value) {
        return new JAXBElement<DeleteMovieById>(_DeleteMovieById_QNAME, DeleteMovieById.class, null, value);
    }

}
