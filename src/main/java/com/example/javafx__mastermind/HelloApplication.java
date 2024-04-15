package com.example.javafx__mastermind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Game game = new Game();
        Scene scene = new Scene(game.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("MASTERMIND!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("END OF PROCESS !");
    }
}