package org.example;

import org.example.entity.Director;
import org.example.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * 1) Получите любой фильм, а затем получите его режиссера.
 * 2) Добавьте еще один фильм для любого режиссера.
 * 3) Создайте нового режиссера и новый фильм и свяжите эти сущности.
 * 4) Смените режиссера у существующего фильма.
 * 5) Удалите фильм у любого режиссера.
 */
public class Functional {
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Functional functional = new Functional();

            Director director = session.get(Director.class, 7);
            Movie movie = session.get(Movie.class, 1);

            functional.removeMovieFromDirector(movie, session);

            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }
    }


    public Director getDirectorByFilm(Movie movie) {
        return movie.getDirector();
    } //correct

    public void addFilmToDirector(Director director, Session session) { //correct
        Movie movie = new Movie(director, "somemovie1", 1987);
        director.getMovieList().add(movie);
        session.merge(movie);
    }

    public void createAndBindNewEntities(Session session) { //correct
        Director director = new Director
                ("New Director", 45, new ArrayList<Movie>());
        Movie movie = new Movie(director, "Some Film", 1999);

        session.persist(director);
        session.persist(movie);
        movie.setDirector(director);
        director.getMovieList().add(movie);
    }

    public void changeTheMovieDirector(Movie movie, Director director, Session session) { //correct

        movie.getDirector().getMovieList().remove(movie);
        movie.setDirector(director);
    }

    public void removeMovieFromDirector(Movie movie, Session session) { //correct
        movie.getDirector().getMovieList().remove(movie);
        movie.setDirector(null);

    }
}
