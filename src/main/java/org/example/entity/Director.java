package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "director")
    private List<Movie> movieList;

    public Director(Long id, String name, int age, List<Movie> movieList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.movieList = movieList;
    }

    public Director(String name, int age, List<Movie> movieList) {
        this.name = name;
        this.age = age;
        this.movieList = movieList;
    }

    public Director() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (age != director.age) return false;
        if (id != null ? !id.equals(director.id) : director.id != null) return false;
        if (name != null ? !name.equals(director.name) : director.name != null) return false;
        return movieList != null ? movieList.equals(director.movieList) : director.movieList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (movieList != null ? movieList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
