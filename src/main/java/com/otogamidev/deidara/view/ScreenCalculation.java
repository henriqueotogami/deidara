package com.otogamidev.deidara.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenCalculation {

    public ScreenCalculation() {

    }

    public void startScreenCalculation(final FXMLLoader fxmlLoader, final Stage stage) throws IOException {
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
