package com.otogamidev.deidara.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenCalculation {

    public ScreenCalculation() {

    }

    public void startScreenCalculation(final Stage stage) throws IOException {

        final int windowWidth = 600;
        final int windowHeight = 600;
        final int barWidth =  200;
        final int barHeight = 600;
        final int algorithmWidth = 400;
        final int algorithmHeight = 600;

        final LeftBar leftBar = new LeftBar(barWidth, barHeight);
        final AlgorithmBody algorithmBody = new AlgorithmBody(algorithmWidth, algorithmHeight);
        final HBox horizontalBox = new HBox();

        stage.setTitle("Hello!");
        horizontalBox.getChildren().add(leftBar);
        horizontalBox.getChildren().add(algorithmBody);
        final Scene scene = new Scene(horizontalBox, windowWidth, windowHeight);
        stage.setScene(scene);
        stage.show();
    }
}
