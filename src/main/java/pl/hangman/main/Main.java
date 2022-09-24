package pl.hangman.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;


import static pl.hangman.services.FileService.createWordsList;

public class Main extends Application {
    public static void main(String[] args) {

        createWordsList();
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        VBox mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainPane.fxml")));
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.show();
    }
}
