package main.java.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by win10 on 29.10.2016.
 */
@Entity
@Table(name = "description")
@NamedQuery(name = "Description.getAll", query = "SELECT d FROM Description d")
public class Description implements Serializable{

    @Id
    @Column(name = "description_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int descriptionId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToOne(mappedBy = "description")
    private Movie movie;

    public Description() {}

    public Description(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Description(String title, String content, Movie movie) {
        this.title = title;
        this.content = content;
        this.movie = movie;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Movie getMovie() {
        return movie;
    }


    public void setMovie(Movie movie) {
        this.movie = movie;

        if (movie != null) {
            movie.setDescription(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Description that = (Description) o;

        if (getDescriptionId() != that.getDescriptionId()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getContent() != null ? getContent().equals(that.getContent()) : that.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = getDescriptionId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Description{title='").append(title)
                .append("', content='").append(content).append("}");

        return stringBuilder.toString();
    }
}
