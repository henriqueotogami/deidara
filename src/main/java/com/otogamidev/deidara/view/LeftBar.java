package com.otogamidev.deidara.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LeftBar {

    private Pane paneLeftBar = new Pane();
    private String pathStyleFile = getClass().getResource("/StyleLeftBar.css").toExternalForm();
    private String pathDeidaraIcon = getClass().getResource("/deidara-icon.png").toExternalForm();
    private String pathGoogleFonts = "https://fonts.googleapis.com/css2?family=Open+Sans";
    private String pathLocalOpenSans =  getClass().getResource("/OpenSans-Bold.ttf").toExternalForm();

    public LeftBar(final int barWidth, final int barHeight){
        System.out.println("LeftBar - LeftBar(): BEGIN");
        paneLeftBar.setPrefWidth(barWidth);
        paneLeftBar.setMinWidth(barWidth);
        paneLeftBar.setMaxWidth(barWidth);
        paneLeftBar.setPrefHeight(barHeight);
        paneLeftBar.setMinHeight(barHeight);
        paneLeftBar.setMaxHeight(barHeight);
        System.out.println("LeftBar - LeftBar(): END");
    }

    public Pane createPaneLeftBar() {

        final VBox buttonsVerticalBox = new VBox();
        final VBox groupVerticalBox = new VBox();

        final Button fieldSelectAlgorithmOne = createFieldSelectAlgorithm("AlgorithmOne");
        final Button fieldSelectAlgorithmTwo = createFieldSelectAlgorithm("AlgorithmTwo");
        final Button fieldSelectAlgorithmThree = createFieldSelectAlgorithm("AlgorithmThree");
        final Button fieldSelectAlgorithmFour = createFieldSelectAlgorithm("AlgorithmFour");
        final Button fieldSelectAlgorithmFive = createFieldSelectAlgorithm("AlgorithmFive");
        final Button fieldSelectAlgorithmSix = createFieldSelectAlgorithm("AlgorithmSix");
        final Button fieldSelectAlgorithmSeven = createFieldSelectAlgorithm("AlgorithmSeven");
        final Button fieldSelectAlgorithmEight = createFieldSelectAlgorithm("AlgorithmEight");
        final Button fieldSelectAlgorithmNine = createFieldSelectAlgorithm("AlgorithmNine");
        final Button fieldSelectAlgorithmTen = createFieldSelectAlgorithm("AlgorithmTen");

        final Image imageDeidara = new Image(pathDeidaraIcon);
        final ImageView iconDeidara = new ImageView();
        final BorderPane paneIconDeidara = new BorderPane();
        final int paddingTop = 0;
        final int paddingLeft = 40;
        final int paddingBottom = 10;
        final int paddingRight = 40;
        final Insets positionIconDeidara = new Insets(paddingTop, paddingLeft, paddingBottom, paddingRight);

        iconDeidara.setImage(imageDeidara);
        iconDeidara.getStyleClass().add("style-deidara-icon");
        iconDeidara.setFitWidth(120);
        iconDeidara.setFitHeight(120);

        paneIconDeidara.setPrefSize(200,220);
        paneIconDeidara.setTop(iconDeidara);
        paneIconDeidara.setPadding(positionIconDeidara);

        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmOne);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmTwo);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmThree);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmFour);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmFive);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmSix);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmSeven);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmEight);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmNine);
        buttonsVerticalBox.getChildren().add(fieldSelectAlgorithmTen);
        buttonsVerticalBox.getStyleClass().add("style-buttons-vertical-box");
        buttonsVerticalBox.getStylesheets().add(pathLocalOpenSans);

        groupVerticalBox.getChildren().add(buttonsVerticalBox);
        groupVerticalBox.getChildren().add(paneIconDeidara);

        paneLeftBar.getChildren().add(groupVerticalBox);
        paneLeftBar.getStyleClass().add("style-pane-left-bar");
        paneLeftBar.getStylesheets().add(pathStyleFile);
        return paneLeftBar;
    }

    private static Button createFieldSelectAlgorithm(final String buttonName) {

        final Button fieldSelectAlgorithm = new Button(buttonName);

        fieldSelectAlgorithm.setPrefWidth(140);
        fieldSelectAlgorithm.setMinWidth(140);
        fieldSelectAlgorithm.setMaxWidth(140);

        fieldSelectAlgorithm.setPrefHeight(25);
        fieldSelectAlgorithm.setMinHeight(25);
        fieldSelectAlgorithm.setMaxHeight(25);
        fieldSelectAlgorithm.getStyleClass().add("style-field-select-algorithm");
        return fieldSelectAlgorithm;
    }
}