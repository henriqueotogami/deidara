package com.otogamidev.deidara.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AlgorithmBody {

    private Pane paneAlgorithmBody = new Pane();
    private String pathStyleFile = getClass().getResource("/StyleAlgorithmBody.css").toExternalForm();

    public AlgorithmBody(final int bodyWidth, final int bodyHeight) {
        System.out.println("AlgorithmBody - AlgorithmBody(): BEGIN");
        paneAlgorithmBody.setPrefWidth(bodyWidth);
        paneAlgorithmBody.setPrefHeight(bodyHeight);
        System.out.println("AlgorithmBody - AlgorithmBody(): END");
    }


    public Pane createAlgorithmBody() {
        final VBox verticalBox = new VBox();
        final TextField fieldInput = new TextField();
        final TextField fieldOutput = new TextField();
        final TextField fieldAboutAlgorithm = new TextField();

        fieldInput.setPrefWidth(300);
        fieldInput.setPrefHeight(20);
        fieldInput.getStyleClass().add("style-field-input");

        fieldOutput.setPrefWidth(300);
        fieldOutput.setPrefHeight(20);
        fieldOutput.getStyleClass().add("style-field-output");

        fieldAboutAlgorithm.setPrefWidth(300);
        fieldAboutAlgorithm.setPrefHeight(220);
        fieldAboutAlgorithm.getStyleClass().add("style-field-about-algorithm");

        verticalBox.getChildren().add(fieldInput);
        verticalBox.getChildren().add(fieldOutput);
        verticalBox.getChildren().add(fieldAboutAlgorithm);

        verticalBox.setAlignment(Pos.CENTER);
        verticalBox.setSpacing(50);
        verticalBox.setPadding(new Insets(0,50,0,50));
        verticalBox.getStyleClass().add("style-vertical-box");
        paneAlgorithmBody.getChildren().add(verticalBox);
        paneAlgorithmBody.getStylesheets().add(pathStyleFile);
        return paneAlgorithmBody;
    }
}
