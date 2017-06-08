package main.java.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by win10 on 29.10.2016.
 */
@Entity
@Table(name = "director")
@NamedQuery(name = "Director.getAll", query = "SELECT d FROM Director d")
public class Director implements Serializable {

    @Id
    @Column(name = "director_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

    public Director() {
        movies = new HashSet<>();
    }

    public Director(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public Director(String name, String surname, Set<Movie> movies) {
        this.name = name;
        this.surname = surname;

        this.movies = movies;
        for (Movie movie : movies) {
            movie.setDirector(this);
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setDirector(this);
    }

    public void removeMovie(int movieId) {
        Iterator<Movie> movieIterator = movies.iterator();
        while (movieIterator.hasNext()) {
            if(movieIterator.next().getMovieId() == movieId) {
                movieIterator.remove();
                return;
            }
        }
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public void setMovies(Set<Movie> movies) {
        if (this.movies != null) {
            Iterator<Movie> movieIterator = this.movies.iterator();

            while (movieIterator.hasNext()) {
                Movie movie = movieIterator.next();
                movie.setDirector(null);
            }
        }

        this.movies = movies;
        for (Movie movie : movies) {
            movie.setDirector(this);
        }
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
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

    public Set<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (getDirectorId() != director.getDirectorId()) return false;
        if (getName() != null ? !getName().equals(director.getName()) : director.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(director.getSurname()) : director.getSurname() == null;

    }

    @Override
    public int hashCode() {
        int result = getDirectorId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Director{, ")
                .append(name).append(" ").append(surname).append("}");

        return stringBuilder.toString();
    }
}
