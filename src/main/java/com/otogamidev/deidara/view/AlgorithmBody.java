package com.otogamidev.deidara.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

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

        final VBox verticalBodyBox = new VBox();
        final VBox fieldInput = createInputBox();
        final VBox fieldOutput = createOutputBox();
        final VBox fieldAboutAlgorithm = createAboutBox();
        final BorderPane paneBody = new BorderPane();

        final int paddingTopPane = 15;
        final int paddingLeftPane = 50;
        final int paddingBottomPane = 0;
        final int paddingRightPane = 50;
        final Insets paddingPaneBody = new Insets(paddingTopPane, paddingLeftPane, paddingBottomPane, paddingRightPane);

        verticalBodyBox.getChildren().add(fieldInput);
        verticalBodyBox.getChildren().add(fieldOutput);
        verticalBodyBox.getChildren().add(fieldAboutAlgorithm);
        verticalBodyBox.getStyleClass().add("style-vertical-box");

        paneBody.setPrefSize(400,600);
        paneBody.setTop(verticalBodyBox);
        paneBody.setPadding(paddingPaneBody);
        paneBody.getStyleClass().add("style-pane-body");

        paneAlgorithmBody.getChildren().add(paneBody);
        paneAlgorithmBody.getStylesheets().add(pathStyleFile);
        return paneAlgorithmBody;
    }

    private static HBox createGroupDataType() {

        final RadioButton buttonASCII = new RadioButton("ASCII");
        final RadioButton buttonHex = new RadioButton("HEX");
        final RadioButton buttonDec = new RadioButton("DEC");
        final RadioButton buttonOct = new RadioButton("OCT");
        final RadioButton buttonBin = new RadioButton("BIN");

        final int paddingTopButton = 0;
        final int paddingLeftButton = 20;
        final int paddingBottomButton = 0;
        final int paddingRightButton = 0;
        final Insets paddingButton = new Insets(paddingTopButton, paddingLeftButton, paddingBottomButton, paddingRightButton);

        buttonASCII.setPadding(paddingButton);
        buttonHex.setPadding(paddingButton);
        buttonDec.setPadding(paddingButton);
        buttonOct.setPadding(paddingButton);
        buttonBin.setPadding(paddingButton);

        final HBox dualHorizontalBox = new HBox();
        final int paddingTopHbox = 0;
        final int paddingLeftHbox = 0;
        final int paddingBotomHbox = 20;
        final int paddingRightHbox = 0;
        final Insets paddingHorizontalBox = new Insets(paddingTopHbox, paddingLeftHbox, paddingBotomHbox, paddingRightHbox);

        dualHorizontalBox.getChildren().add(buttonASCII);
        dualHorizontalBox.getChildren().add(buttonHex);
        dualHorizontalBox.getChildren().add(buttonDec);
        dualHorizontalBox.getChildren().add(buttonOct);
        dualHorizontalBox.getChildren().add(buttonBin);
        dualHorizontalBox.setPadding(paddingHorizontalBox);
        dualHorizontalBox.getStyleClass().add("style-text-radio-buttons");

        return dualHorizontalBox;
    }

    private static VBox createInputBox() {

        final VBox verticalInputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox inputSelectDataType = createGroupDataType();

        final Text textInput = new Text("INPUT");
        final Hyperlink textClickToExpand = new Hyperlink("CLICK TO EXPAND");
        final TextField fieldInput = new TextField();
        final ColumnConstraints columnZeroWidth = new ColumnConstraints(150);
        final ColumnConstraints columnOneWidth = new ColumnConstraints(150);

        textInput.getStyleClass().add("style-title-field-input");
        textClickToExpand.getStyleClass().add("style-text-click-expand");

        horizontalHeaderPane.getColumnConstraints().add(columnZeroWidth);
        horizontalHeaderPane.getColumnConstraints().add(columnOneWidth);
        horizontalHeaderPane.addRow(0,textInput,textClickToExpand);
        horizontalHeaderPane.getColumnConstraints().get(0).setHalignment(HPos.LEFT);
        horizontalHeaderPane.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);

        fieldInput.setPrefWidth(300);
        fieldInput.setPrefHeight(25);
        fieldInput.getStyleClass().add("style-field-input");

        verticalInputBox.getChildren().add(horizontalHeaderPane);
        verticalInputBox.getChildren().add(fieldInput);
        verticalInputBox.getChildren().add(inputSelectDataType);

        return verticalInputBox;
    }

    private static VBox createOutputBox() {

        final VBox verticalOutputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox outputSelectDataType = createGroupDataType();

        final Text textOutput = new Text("OUTPUT");
        final Hyperlink textClickToExpand = new Hyperlink("CLICK TO EXPAND");
        final TextField fieldOutput = new TextField();
        final ColumnConstraints columnZeroWidth = new ColumnConstraints(150);
        final ColumnConstraints columnOneWidth = new ColumnConstraints(150);

        textOutput.getStyleClass().add("style-title-field-output");
        textClickToExpand.getStyleClass().add("style-text-click-expand");

        horizontalHeaderPane.getColumnConstraints().add(columnZeroWidth);
        horizontalHeaderPane.getColumnConstraints().add(columnOneWidth);
        horizontalHeaderPane.addRow(0,textOutput,textClickToExpand);
        horizontalHeaderPane.getColumnConstraints().get(0).setHalignment(HPos.LEFT);
        horizontalHeaderPane.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);

        fieldOutput.setPrefWidth(300);
        fieldOutput.setPrefHeight(25);
        fieldOutput.getStyleClass().add("style-field-output");

        verticalOutputBox.getChildren().add(horizontalHeaderPane);
        verticalOutputBox.getChildren().add(fieldOutput);
        verticalOutputBox.getChildren().add(outputSelectDataType);

        return verticalOutputBox;
    }

    private static VBox createAboutBox() {

        final VBox verticalAboutBox = new VBox();
        final Text textAbout = new Text("About this algorithm");
        final TextField fieldAboutAlgorithm = new TextField();

        final int paddingTopAbout = 100;
        final int paddingLeftAbout = 0;
        final int paddingBottomAbout = 0;
        final int paddingRightAbout = 0;
        final Insets paddingAbout = new Insets(paddingTopAbout, paddingLeftAbout, paddingBottomAbout, paddingRightAbout);

        textAbout.getStyleClass().add("style-title-about-body");

        fieldAboutAlgorithm.setPrefWidth(300);
        fieldAboutAlgorithm.setPrefHeight(220);
        fieldAboutAlgorithm.getStyleClass().add("style-field-about-algorithm");

        verticalAboutBox.getChildren().add(textAbout);
        verticalAboutBox.getChildren().add(fieldAboutAlgorithm);

        return verticalAboutBox;
    }
}
