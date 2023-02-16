package com.otogamidev.deidara.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ScreenCalculation {

    public ScreenCalculation() {

    }
    private String pathStyleFile = getClass().getResource("/StyleScreenCalculation.css").toExternalForm();

    public void startScreenCalculation(final Stage stage) throws IOException {

        final int windowWidth = 600;
        final int windowHeight = 600;
        final int barWidth =  200;
        final int barHeight = 600;
        final int algorithmWidth = 400;
        final int algorithmHeight = 600;

        final LeftBar leftBar = new LeftBar(barWidth, barHeight);
        final AlgorithmBody algorithmBody = new AlgorithmBody(algorithmWidth, algorithmHeight);
        final HBox horizontalBoxBody = createWindowBody(windowWidth, windowHeight, leftBar, algorithmBody);
        final HBox horizontalWindowsTopButtons = createWindowHeader();
        final VBox verticalBoxHeaderAndBody = new VBox();

        verticalBoxHeaderAndBody.getChildren().add(horizontalWindowsTopButtons);
        verticalBoxHeaderAndBody.getChildren().add(horizontalBoxBody);
        verticalBoxHeaderAndBody.getStylesheets().add(pathStyleFile);

        final Scene scene = new Scene(verticalBoxHeaderAndBody, windowWidth, windowHeight);

//        stage.setTitle("Deidara - CRC");
        stage.initStyle(StageStyle.UNDECORATED);
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

    private static HBox createWindowHeader() {
        final HBox horizontalWindowsTopButtons = new HBox();

        final Button closeButton = new Button();
        final Button minimizeButton = new Button();
        final Button zoomButton = new Button();

        closeButton.getStyleClass().add("style-close-window-button-red");
        minimizeButton.getStyleClass().add("style-minimize-window-button-yellow");
        zoomButton.getStyleClass().add("style-zoom-window-button-green");

        horizontalWindowsTopButtons.getChildren().add(closeButton);
        horizontalWindowsTopButtons.getChildren().add(minimizeButton);
        horizontalWindowsTopButtons.getChildren().add(zoomButton);
        return horizontalWindowsTopButtons;
    }

    private static HBox createWindowBody(int windowWidth, int windowHeight, LeftBar leftBar, AlgorithmBody algorithmBody) {
        final HBox horizontalBox = new HBox();

        horizontalBox.setPrefHeight(windowHeight);
        horizontalBox.setMinHeight(windowHeight);
        horizontalBox.setMaxHeight(windowHeight);
        horizontalBox.setPrefWidth(windowWidth);
        horizontalBox.setMinWidth(windowWidth);
        horizontalBox.setMaxWidth(windowWidth);
        horizontalBox.getChildren().add(leftBar.createPaneLeftBar());
        horizontalBox.getChildren().add(algorithmBody.createAlgorithmBody());
        return horizontalBox;
    }
}
