package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    public Movie(Long id, Director director, String name, int yearOfProduction) {
        this.id = id;
        this.director = director;
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie(Director director, String name, int yearOfProduction) {
        this.director = director;
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie(String name, int yearOfProduction) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (yearOfProduction != movie.yearOfProduction) return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearOfProduction;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("id=").append(id);
        sb.append(", director=").append(director);
        sb.append(", name='").append(name).append('\'');
        sb.append(", yearOfProduction=").append(yearOfProduction);
        sb.append('}');
        return sb.toString();
    }
}
