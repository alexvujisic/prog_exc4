package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.controllers.Observer;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Observable{

    Dao<WatchlistMovieEntity, Long> dao;
    private static WatchlistRepository instance;
    private final List<Observer> observers;

    public static WatchlistRepository getInstance() throws DataBaseException {
        if (instance == null) {
            instance = new WatchlistRepository();
        }
        return instance;
    }


    public WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
        observers = new ArrayList<Observer>();
    }

    public List<WatchlistMovieEntity> readWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }
    public void addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                dao.create(movie);
                notifyObservers("Movie successfully added to watchlist");
            }else{
                notifyObservers("Movie already on watchlist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public void removeFromWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            dao.delete(movie);
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }

    public boolean isOnWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            return dao.queryForMatching(movie).size() > 0;
        } catch (Exception e) {
            throw new DataBaseException("Error while checking if movie is on watchlist");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String notification) {
        this.observers.forEach(observer -> observer.update(notification));
    }
}
