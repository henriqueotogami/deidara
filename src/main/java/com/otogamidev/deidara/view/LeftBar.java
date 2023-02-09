package com.otogamidev.deidara.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LeftBar {

    private Pane paneLeftBar = new Pane();
    private String pathStyleFile = getClass().getResource("/StyleLeftBar.css").toExternalForm();
    private String pathDeidaraIcon = getClass().getResource("/deidara-icon.png").toExternalForm();

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
        final VBox verticalBox = new VBox();

        final TextField fieldSelectAlgorithmOne = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmTwo = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmThree = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmFour = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmFive = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmSix = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmSeven = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmEight = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmNine = createFieldSelectAlgorithm();
        final TextField fieldSelectAlgorithmTen = createFieldSelectAlgorithm();

        final Image imageDeidara = new Image(pathDeidaraIcon);
        final ImageView iconDeidara = new ImageView();
        iconDeidara.setImage(imageDeidara);
        iconDeidara.getStyleClass().add("style-deidara-icon");

        verticalBox.getChildren().add(fieldSelectAlgorithmOne);
        verticalBox.getChildren().add(fieldSelectAlgorithmTwo);
        verticalBox.getChildren().add(fieldSelectAlgorithmThree);
        verticalBox.getChildren().add(fieldSelectAlgorithmFour);
        verticalBox.getChildren().add(fieldSelectAlgorithmFive);
        verticalBox.getChildren().add(fieldSelectAlgorithmSix);
        verticalBox.getChildren().add(fieldSelectAlgorithmSeven);
        verticalBox.getChildren().add(fieldSelectAlgorithmEight);
        verticalBox.getChildren().add(fieldSelectAlgorithmNine);
        verticalBox.getChildren().add(fieldSelectAlgorithmTen);

        verticalBox.setSpacing(10);
        verticalBox.getStyleClass().add("style-vertical-box");
        paneLeftBar.getChildren().add(verticalBox);
        paneLeftBar.getChildren().add(iconDeidara);
        paneLeftBar.getStylesheets().add(pathStyleFile);
        return paneLeftBar;
    }

    private static TextField createFieldSelectAlgorithm() {
        final TextField fieldSelectAlgorithm = new TextField();

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
