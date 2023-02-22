package com.otogamidev.deidara.views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

        final Button buttonBackToHomePage = createButtonBackToHomePage();

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

        final Hyperlink hyperlinkRepository = new Hyperlink("deidara");

        final int paddingImageTop = 0;
        final int paddingImageLeft = 40;
        final int paddingImageBottom = 10;
        final int paddingImageRight = 40;
        final Insets positionIconDeidara = new Insets(paddingImageTop, paddingImageLeft, paddingImageBottom, paddingImageRight);

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

        iconDeidara.setImage(imageDeidara);
        iconDeidara.getStyleClass().add("style-deidara-icon");
        iconDeidara.setFitWidth(120);
        iconDeidara.setFitHeight(120);

        paneIconDeidara.setPrefSize(200,220);
        paneIconDeidara.setTop(iconDeidara);
        paneIconDeidara.setPadding(positionIconDeidara);

        groupVerticalBox.getChildren().add(buttonBackToHomePage);
        groupVerticalBox.getChildren().add(buttonsVerticalBox);
        groupVerticalBox.getChildren().add(paneIconDeidara);
        groupVerticalBox.getChildren().add(hyperlinkRepository);
        groupVerticalBox.getStyleClass().add("style-vertical-box");

        paneLeftBar.getChildren().add(groupVerticalBox);
        paneLeftBar.getStyleClass().add("style-pane-left-bar");
        paneLeftBar.getStylesheets().add(pathStyleFile);
        return paneLeftBar;
    }

    private static Button createButtonBackToHomePage() {
        final int paddingButtonTop = 55;
        final int paddingButtonLeft = 0;
        final int paddingButtonBottom = 0;
        final int paddingButtonRight = 10;
        final Insets positionButtonBackHome = new Insets(paddingButtonTop, paddingButtonLeft, paddingButtonBottom, paddingButtonRight);

        final Button buttonBackToHomePage = new Button("< BACK");

        buttonBackToHomePage.setMaxWidth(100);
        buttonBackToHomePage.setMinWidth(100);
        buttonBackToHomePage.setPrefWidth(100);
        buttonBackToHomePage.setMaxHeight(20);
        buttonBackToHomePage.setMinWidth(20);
        buttonBackToHomePage.setPrefWidth(20);
        buttonBackToHomePage.setPadding(positionButtonBackHome);
        buttonBackToHomePage.getStyleClass().add("style-button-back-home-page");

        return buttonBackToHomePage;
    }

    private static Button createFieldSelectAlgorithm(final String buttonName) {

        final Button fieldSelectAlgorithm = new Button(buttonName);

        fieldSelectAlgorithm.setPrefWidth(140);
        fieldSelectAlgorithm.setMinWidth(140);
        fieldSelectAlgorithm.setMaxWidth(140);

        fieldSelectAlgorithm.setPrefHeight(20);
        fieldSelectAlgorithm.setMinHeight(20);
        fieldSelectAlgorithm.setMaxHeight(20);
        fieldSelectAlgorithm.getStyleClass().add("style-field-select-algorithm");

        return fieldSelectAlgorithm;
    }
}