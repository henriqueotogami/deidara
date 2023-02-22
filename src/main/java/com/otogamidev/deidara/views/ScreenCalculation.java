package com.otogamidev.deidara.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
//        final GridPane horizontalWindowsTopButtons = createWindowHeader();
        final VBox verticalBoxHeaderAndBody = new VBox();

//        verticalBoxHeaderAndBody.getChildren().add(horizontalWindowsTopButtons);
        verticalBoxHeaderAndBody.getChildren().add(horizontalBoxBody);
        verticalBoxHeaderAndBody.getStyleClass().add("style-vertical-box-header-and-body");

        final Scene scene = new Scene(verticalBoxHeaderAndBody, windowWidth, windowHeight);
//        scene.setFill(Color.TRANSPARENT);

//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setWidth(windowWidth);
        stage.setMinWidth(windowWidth);
        stage.setMaxWidth(windowWidth);
        stage.setHeight(windowHeight);
        stage.setMinHeight(windowHeight);
        stage.setMaxHeight(windowHeight);
        stage.setScene(scene);
        stage.getScene().getStylesheets().setAll(pathStyleFile);
        stage.show();
    }

    private GridPane createWindowHeader() {
        final HBox horizontalWindowsTopButtons = new HBox();

        final Button closeButton = new Button();
        final Button minimizeButton = new Button();
        final Button zoomButton = new Button();

        closeButton.setOnAction(
                (final ActionEvent actionEvent) -> {
                    Platform.exit();
                }
        );

        closeButton.setPrefHeight(15);
        closeButton.setMinHeight(15);
        closeButton.setMaxHeight(15);
        closeButton.setPrefWidth(15);
        closeButton.setMinWidth(15);
        closeButton.setMaxWidth(15);

        minimizeButton.setPrefHeight(15);
        minimizeButton.setMinHeight(15);
        minimizeButton.setMaxHeight(15);
        minimizeButton.setPrefWidth(15);
        minimizeButton.setMinWidth(15);
        minimizeButton.setMaxWidth(15);

        zoomButton.setPrefHeight(15);
        zoomButton.setMinHeight(15);
        zoomButton.setMaxHeight(15);
        zoomButton.setPrefWidth(15);
        zoomButton.setMinWidth(15);
        zoomButton.setMaxWidth(15);

        closeButton.getStyleClass().add("style-close-window-button-red");
        minimizeButton.getStyleClass().add("style-minimize-window-button-yellow");
        zoomButton.getStyleClass().add("style-zoom-window-button-green");

        final int paddingTopButton = 20;
        final int paddingLeftButton = 0;
        final int paddingBottomButton = 10;
        final int paddingRightButton = 20;
        final Insets paddingWindowTopButtons = new Insets(paddingTopButton, paddingLeftButton, paddingBottomButton, paddingRightButton);

        horizontalWindowsTopButtons.getChildren().add(closeButton);
        horizontalWindowsTopButtons.getChildren().add(minimizeButton);
        horizontalWindowsTopButtons.getChildren().add(zoomButton);
        horizontalWindowsTopButtons.setSpacing(5);
        horizontalWindowsTopButtons.setPadding(paddingWindowTopButtons);
        horizontalWindowsTopButtons.getStyleClass().add("style-left-color-header");

        final GridPane twiceColorHeader = new GridPane();
        final Pane emptyHeader = new Pane();
        final ColumnConstraints columnZeroWidth = new ColumnConstraints(200);
        final ColumnConstraints columnOneWidth = new ColumnConstraints(400);

        emptyHeader.getStyleClass().add("style-right-color-header");

        twiceColorHeader.getColumnConstraints().add(columnZeroWidth);
        twiceColorHeader.getColumnConstraints().add(columnOneWidth);
        twiceColorHeader.addRow(0,horizontalWindowsTopButtons, emptyHeader);

        return twiceColorHeader;
    }

    private HBox createWindowBody(final int windowWidth, final int windowHeight, final LeftBar leftBar, final AlgorithmBody algorithmBody) {

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
