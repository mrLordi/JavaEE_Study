package entities;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
@Entity
@XmlRootElement
@Table(name = "producer")
@NamedQuery(name = "Producer.getAll", query = "SELECT p FROM Producer p")
public class Producer implements Serializable {

    @Id
    @Column(name = "producer_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(mappedBy = "producers", fetch = FetchType.EAGER)
    @JsonManagedReference
    @XmlTransient
    private List<Movie> movies;

    public Producer() {
        movies = new ArrayList<>();
    }

    public Producer(String name, String surname, String type) {
        this();
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    public Producer(String name, String surname, String type, List<Movie> movies) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (movies.add(movie)) {
            if (!movie.getProducers().contains(this)) {
                movie.addProducer(this);
            }
        }
    }

    public void removeMovie(int movieId) {
        for (Movie movie : movies) {
            if(movie.getMovieId() == movieId) {
                movies.remove(movie);
                movie.removeProducer(this);
                return;
            }
        }
    }

    public void removeMovie(Movie movie) {
        if (movies.remove(movie)) {
            movie.removeProducer(this);
        }
    }

    public void setMovies(List<Movie> movies) {
        if (this.movies != null) {
            Iterator<Movie> movieIterator = this.movies.iterator();
            movieIterator.next();
            while (movieIterator.hasNext()) {
                Movie movie = movieIterator.next();
                movie.removeProducer(this);
            }
        }

        this.movies = movies;
        for (Movie movie : movies) {
            movie.addProducer(this);
        }
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        if (getProducerId() != producer.getProducerId()) return false;
        if (getName() != null ? !getName().equals(producer.getName()) : producer.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(producer.getSurname()) : producer.getSurname() != null)
            return false;
        return getType() != null ? getType().equals(producer.getType()) : producer.getType() == null;

    }

    @Override
    public int hashCode() {
        int result = getProducerId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Producer{").append(name).append(" ").append(surname)
                .append(", type=").append(type).append("}");

        return stringBuilder.toString();
    }
}
