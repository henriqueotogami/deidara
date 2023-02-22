package com.otogamidev.deidara.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class AlgorithmBody {

    private Pane paneAlgorithmBody = new Pane();
    private String pathStyleFile = getClass().getResource("/StyleAlgorithmBody.css").toExternalForm();

    private final TextField fieldInput = new TextField();
    private final TextField fieldOutput = new TextField();
    final Button buttonCalculateCRC = new Button("CALCULATE");

    public AlgorithmBody(final int bodyWidth, final int bodyHeight) {
        System.out.println("AlgorithmBody - AlgorithmBody(): BEGIN");
        paneAlgorithmBody.setPrefWidth(bodyWidth);
        paneAlgorithmBody.setMaxWidth(bodyWidth);
        paneAlgorithmBody.setMinWidth(bodyWidth);
        paneAlgorithmBody.setPrefHeight(bodyHeight);
        paneAlgorithmBody.setMaxHeight(bodyHeight);
        paneAlgorithmBody.setMinHeight(bodyHeight);
        System.out.println("AlgorithmBody - AlgorithmBody(): END");
    }

    public TextField getFieldInput() { return fieldInput; }

    public TextField getFieldOutput() { return fieldOutput; }

    public Button getButtonCalculateCRC() { return buttonCalculateCRC; }

    public Pane createAlgorithmBody() {

        final VBox verticalBodyBox = new VBox();
        final VBox fieldInput = createInputBox();
        final VBox fieldOutput = createOutputBox();
        final VBox fieldAboutAlgorithm = createAboutBox();
        final BorderPane paneBody = new BorderPane();
        final TextField headerNameAlgorithm = createHeaderNameAlgorithm();

        final int paddingTopPane = 15;
        final int paddingLeftPane = 50;
        final int paddingBottomPane = 0;
        final int paddingRightPane = 50;
        final Insets paddingPaneBody = new Insets(paddingTopPane, paddingLeftPane, paddingBottomPane, paddingRightPane);

        final int paddingButtonTopPane = 0;
        final int paddingButtonLeftPane = 0;
        final int paddingButtonBottomPane = 0;
        final int paddingButtonRightPane = 0;
        final Insets paddingButtonCalculateCRC = new Insets(paddingButtonTopPane, paddingButtonLeftPane, paddingButtonBottomPane, paddingButtonRightPane);

        buttonCalculateCRC.setMinWidth(140);
        buttonCalculateCRC.setMaxWidth(140);
        buttonCalculateCRC.setPrefWidth(140);
        buttonCalculateCRC.setMinHeight(20);
        buttonCalculateCRC.setMaxHeight(20);
        buttonCalculateCRC.setPrefHeight(20);
        buttonCalculateCRC.setPadding(paddingButtonCalculateCRC);
        buttonCalculateCRC.getStyleClass().add("style-button-calculate-crc");

        verticalBodyBox.setPrefWidth(300);
        verticalBodyBox.setPrefHeight(500);
        verticalBodyBox.getChildren().add(headerNameAlgorithm);
        verticalBodyBox.getChildren().add(fieldInput);
        verticalBodyBox.getChildren().add(buttonCalculateCRC);
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

    private static TextField createHeaderNameAlgorithm() {

        final TextField headerNameAlgorithm = new TextField("ALGORITHM-01");

        headerNameAlgorithm.setMaxWidth(300);
        headerNameAlgorithm.setMinWidth(300);
        headerNameAlgorithm.setPrefWidth(400);
        headerNameAlgorithm.setMaxHeight(35);
        headerNameAlgorithm.setMinHeight(35);
        headerNameAlgorithm.setPrefHeight(35);
        headerNameAlgorithm.setEditable(false);
        headerNameAlgorithm.getStyleClass().add("style-header-name-algorithm");

        return headerNameAlgorithm;
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

        buttonASCII.getStyleClass().add("style-text-radio-buttons");
        buttonHex.getStyleClass().add("style-text-radio-buttons");
        buttonDec.getStyleClass().add("style-text-radio-buttons");
        buttonOct.getStyleClass().add("style-text-radio-buttons");
        buttonBin.getStyleClass().add("style-text-radio-buttons");

        final HBox dualHorizontalBox = new HBox();
        final int paddingTopHbox = 0;
        final int paddingLeftHbox = 0;
        final int paddingBottomHbox = 20;
        final int paddingRightHbox = 0;
        final Insets paddingHorizontalBox = new Insets(paddingTopHbox, paddingLeftHbox, paddingBottomHbox, paddingRightHbox);

        dualHorizontalBox.getChildren().add(buttonASCII);
        dualHorizontalBox.getChildren().add(buttonHex);
        dualHorizontalBox.getChildren().add(buttonDec);
        dualHorizontalBox.getChildren().add(buttonOct);
        dualHorizontalBox.getChildren().add(buttonBin);
        dualHorizontalBox.setPadding(paddingHorizontalBox);

        return dualHorizontalBox;
    }

    private VBox createInputBox() {

        final VBox verticalInputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox inputSelectDataType = createGroupDataType();

        final Label titleFieldInput = new Label("INPUT");
        final Hyperlink textClickToExpand = new Hyperlink("CLICK TO EXPAND");

        final ColumnConstraints columnZeroWidth = new ColumnConstraints(150);
        final ColumnConstraints columnOneWidth = new ColumnConstraints(150);

        titleFieldInput.getStyleClass().add("style-title-field-input");
        textClickToExpand.getStyleClass().add("style-text-click-expand");

        horizontalHeaderPane.getColumnConstraints().add(columnZeroWidth);
        horizontalHeaderPane.getColumnConstraints().add(columnOneWidth);
        horizontalHeaderPane.addRow(0,titleFieldInput,textClickToExpand);
        horizontalHeaderPane.getColumnConstraints().get(0).setHalignment(HPos.LEFT);
        horizontalHeaderPane.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);

        this.fieldInput.setPrefWidth(300);
        fieldInput.setPrefHeight(25);
        fieldInput.getStyleClass().add("style-field-input");

        verticalInputBox.getChildren().add(horizontalHeaderPane);
        verticalInputBox.getChildren().add(fieldInput);
        verticalInputBox.getChildren().add(inputSelectDataType);

        return verticalInputBox;
    }

    private VBox createOutputBox() {

        final VBox verticalOutputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox outputSelectDataType = createGroupDataType();

        final Label textOutput = new Label("OUTPUT");
        final Hyperlink textClickToExpand = new Hyperlink("CLICK TO EXPAND");

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

    private VBox createAboutBox() {

        final VBox verticalAboutBox = new VBox();
        final Label titleAboutAlgorithm = new Label("About this algorithm");
        final TextArea fieldAboutAlgorithm = new TextArea();

        final Text innerTextFieldAboutLoremIpsum = new Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                    "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                    "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                    "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                    "mollit anim id est laborum."
        );

        final int paddingTopAbout = 100;
        final int paddingLeftAbout = 0;
        final int paddingBottomAbout = 0;
        final int paddingRightAbout = 0;
        final Insets paddingAbout = new Insets(paddingTopAbout, paddingLeftAbout, paddingBottomAbout, paddingRightAbout);

        titleAboutAlgorithm.getStyleClass().add("style-title-about-algorithm");
        innerTextFieldAboutLoremIpsum.getStyleClass().add("style-inner-text-field-about-algorithm");

        fieldAboutAlgorithm.setPrefWidth(300);
        fieldAboutAlgorithm.setPrefHeight(220);
        fieldAboutAlgorithm.setText(innerTextFieldAboutLoremIpsum.getText());
        fieldAboutAlgorithm.setEditable(false);
        fieldAboutAlgorithm.getStyleClass().add("style-field-about-algorithm");

        verticalAboutBox.getChildren().add(titleAboutAlgorithm);
        verticalAboutBox.getChildren().add(fieldAboutAlgorithm);

        return verticalAboutBox;
    }
}
