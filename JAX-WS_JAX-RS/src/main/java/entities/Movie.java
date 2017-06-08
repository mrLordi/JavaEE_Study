package entities;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
@Entity
@XmlRootElement
@Table(name = "movie")
@NamedQuery(name = "Movie.getAll", query = "SELECT m FROM Movie m")
public class Movie implements Serializable {

    @Id
    @Column(name = "movie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "year", nullable = false)
    private int year;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "description_id", unique = true, nullable = false)
    @JsonBackReference(value = "movieDescription")
    private Description description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "director_id", nullable = false)
    @JsonBackReference(value = "movieDirector")
    private Director director;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_producer",
                joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "movie_id")},
                inverseJoinColumns = {@JoinColumn(name = "producer_id", referencedColumnName = "producer_id")})
    @JsonBackReference(value = "movieAllProducers")
    private List<Producer> producers;

    public Movie() {
        producers = new ArrayList<>();
    }

    public Movie(String name, int duration, int year, Description description, Director director) {
        this();
        this.name = name;
        this.duration = duration;
        this.year = year;
        this.director = director;
        this.description = description;
    }

    public Movie(String name, int duration, int year, Description description, Director director, List<Producer> producers) {
        this.name = name;
        this.duration = duration;
        this.year = year;
        this.description = description;
        this.director = director;
        this.producers = producers;
    }

    public void addProducer(Producer producer) {
        if (producers.add(producer)) {
            if (!producer.getMovies().contains(this)) {
                producer.addMovie(this);
            }
        }
    }

    public void removeProducer(int producerId) {
        for (Producer producer : producers) {
            if(producer.getProducerId() == producerId) {
                producers.remove(producer);
                producer.removeMovie(this);
                return;
            }
        }
    }

    public void removeProducer(Producer producer) {
        if (producers.remove(producer)) {
            producer.removeMovie(this);
        }
    }

    public void setProducers(List<Producer> producers) {
        if (this.producers != null) {
            Iterator<Producer> producerIterator = this.producers.iterator();
            while (producerIterator.hasNext()) {
                Producer producer = producerIterator.next();
                producer.removeMovie(this);
            }
        }

        this.producers = producers;
        for (Producer producer : producers) {
            producer.addMovie(this);
        }
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        if (this.description == null) {
            this.description = description;
            description.setMovie(this);
            return;
        }

        if (this.description.equals(description)) {
            return;
        }

        this.description.setMovie(null);
        this.description = description;
        description.setMovie(this);

    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        if (this.director != null) {
            if (this.director.equals(director)) {
                return;
            }

            this.director.removeMovie(this);
            this.director = director;
            director.addMovie(this);
        } else {
            this.director = director;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getMovieId() != movie.getMovieId()) return false;
        if (getDuration() != movie.getDuration()) return false;
        if (getYear() != movie.getYear()) return false;
        if (getName() != null ? !getName().equals(movie.getName()) : movie.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(movie.getDescription()) : movie.getDescription() != null)
            return false;
        return getDirector() != null ? getDirector().equals(movie.getDirector()) : movie.getDirector() == null;

    }

    @Override
    public int hashCode() {
        int result = getMovieId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getDuration();
        result = 31 * result + getYear();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDirector() != null ? getDirector().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Movie{name='").append(name).append("',duration=")
                .append(duration).append("sec, year=").append(year).append(", description=[title=")
                .append(description.getTitle()).append(",content=").append(description.getContent())
                .append("], director=").append(director.getName()).append(" ").append(director.getSurname())
                .append(", producers={");

        if (producers != null && producers.size() > 0) {
            for (Producer producer : producers) {
                stringBuilder.append(producer.getName()).append(" ").append(producer.getSurname())
                        .append(", type=").append(producer.getType()).append(";");
            }
        } else {
            stringBuilder.append("}");
        }

        return stringBuilder.append("}").toString();
    }
}
