package org.example;

import org.example.entity.Director;
import org.example.entity.Movie;

public interface App {
    Director getDirectorByFilm(Movie movie);
    void addFilmToDirector(Movie movie, Director director);
    void createAndBindNewEntities();
    void changeTheMovieDirector(Movie movie, Director director);
    void removeMovieFromDirector(Movie movie);
}
