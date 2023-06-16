package at.ac.fhcampuswien.fhmdb.states;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;
import java.util.List;

public class AscendingState implements MovieListState {

    @Override
    public List<Movie> sorted(MovieListController mlc, List<Movie> movies) {
        mlc.setState(new DscendingState());
        movies.sort(Comparator.comparing(Movie::getTitle));

        return movies;
    }




    @Override
    public void printStatus() {

    }

    @Override
    public List<Movie> getSortedMovies() {
        return null;
    }
}
