package at.ac.fhcampuswien.fhmdb.states;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public interface MovieListState {
    List<Movie> sorted(MovieListController mlc, List<Movie> movies);
    void printStatus();

    List<Movie> getSortedMovies();
}
