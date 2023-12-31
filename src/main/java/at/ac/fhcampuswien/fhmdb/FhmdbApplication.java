package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import at.ac.fhcampuswien.fhmdb.controllers.WatchlistController;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.enums.UIComponent;
import at.ac.fhcampuswien.fhmdb.factory.MyFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource(UIComponent.HOME.path));

        try{
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("/styles/styles.css")).toExternalForm());
            stage.setTitle("FHMDb!");
            stage.setScene(scene);
            MyFactory myFactory = new MyFactory();
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("home.fxml"));
            loader.setControllerFactory(myFactory);
            FXMLLoader loader2 = new FXMLLoader(WatchlistController.class.getResource("watchlist.fxml"));
            loader2.setControllerFactory(myFactory);
            //WatchlistController.getInstance();
            stage.show();
        } catch (IOException e) {
            System.err.println("Cannot load scene from " + UIComponent.HOME.path);
        } catch (NullPointerException e) {
            System.err.println("Path to stylesheet may be corrupt.");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}