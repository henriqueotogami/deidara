package com.otogamidev.deidara.view;

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

        horizontalBox.setPrefHeight(windowHeight);
        horizontalBox.setMinHeight(windowHeight);
        horizontalBox.setMaxHeight(windowHeight);
        horizontalBox.setPrefWidth(windowWidth);
        horizontalBox.setMinWidth(windowWidth);
        horizontalBox.setMaxWidth(windowWidth);
        horizontalBox.getChildren().add(leftBar.createPaneLeftBar());
        horizontalBox.getChildren().add(algorithmBody.createAlgorithmBody());

        final Scene scene = new Scene(horizontalBox, windowWidth, windowHeight);

        stage.setTitle("Deidara - CRC");
        stage.setResizable(false);
        stage.setWidth(windowWidth);
        stage.setMinWidth(windowWidth);
        stage.setMaxWidth(windowWidth);
        stage.setHeight(windowHeight);
        stage.setMinHeight(windowHeight);
        stage.setMaxHeight(windowHeight);
        stage.setScene(scene);
        stage.show();
    }
}
