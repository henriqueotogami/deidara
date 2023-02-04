package com.otogamidev.deidara.controller;

import com.otogamidev.deidara.view.ScreenCalculation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenCalculation extends Application {
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartScreenCalculation.class.getResource("/hello-view.fxml"));
        final ScreenCalculation screenCalculation = new ScreenCalculation();
        screenCalculation.startScreenCalculation(fxmlLoader, stage);
    }

    public static void main(String[] args) {
        launch();
    }
}