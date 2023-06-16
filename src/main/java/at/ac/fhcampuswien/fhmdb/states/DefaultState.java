package at.ac.fhcampuswien.fhmdb.states;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public class DefaultState implements MovieListState {

    //private List<Movie> listOfMovies;// = new ArrayList<>();
    @Override
    public List<Movie> sorted(MovieListController mlc, List<Movie> movies) {
        mlc.setState(new AscendingState());

        return movies;
        //return null;
    }

    @Override
    public void printStatus() {

    }

    @Override
    public List<Movie> getSortedMovies() {
        //return this.listOfMovies;
        return null;
    }
}
