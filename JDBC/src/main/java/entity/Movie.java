package entity;

/**
 * Created by win10 on 03.10.2016.
 */
public class Movie {

    private int id;
    private String name;
    private int duration;
    private int year;
    private int descriptionId;
    private int directorId;

    public Movie(String name, int duration, int year, int descriptionId, int directorId) {
        this.name = name;
        this.duration = duration;
        this.year = year;
        this.descriptionId = descriptionId;
        this.directorId = directorId;
    }

    public Movie(int id, String name, int duration, int year, int descriptionId, int directorId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.year = year;
        this.descriptionId = descriptionId;
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getId() != movie.getId()) return false;
        if (getDuration() != movie.getDuration()) return false;
        if (getYear() != movie.getYear()) return false;
        if (getDescriptionId() != movie.getDescriptionId()) return false;
        if (getDirectorId() != movie.getDirectorId()) return false;
        return getName() != null ? getName().equals(movie.getName()) : movie.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getDuration();
        result = 31 * result + getYear();
        result = 31 * result + getDescriptionId();
        result = 31 * result + getDirectorId();
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", descriptionId=" + descriptionId +
                ", directorId=" + directorId +
                '}';
    }
}
