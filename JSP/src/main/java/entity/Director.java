package main.java.entity;

/**
 * Created by win10 on 08.10.2016.
 */
public class Director {

    private int id;
    private String name;
    private String surname;

    public Director() {}

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Director(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (getId() != director.getId()) return false;
        if (getName() != null ? !getName().equals(director.getName()) : director.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(director.getSurname()) : director.getSurname() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Direcror{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
