package com.otogamidev.deidara.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Classe responsável pela composição visual do corpo do algoritmo, contendo os campos de entrada e saída de dados,
 * botões de ação do usuário, seleção de algoritmos e informacão sobre o algoritmo selecionado.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class AlgorithmBody {

//    Atributos da classe AlgorithmBody
    private Pane paneAlgorithmBody = new Pane();
    private String pathStyleFile = getClass().getResource("/StyleAlgorithmBody.css").toExternalForm();
    private final TextField fieldInput = new TextField();
    private final TextField fieldOutput = new TextField();
    private final Button buttonCalculateCRC = new Button("CALCULATE");
    private String dataTypedByUser = null;
    private boolean isFieldInputClicked = false;
    private boolean isButtonCalculateCrcClicked = false;

//    Métodos da classe AlgorithmBody

    /**
     * Método construtor da classe AlgorithmBody.
     * @param bodyWidth Instância contendo o valor da largura da coluna do corpo.
     * @param bodyHeight Instância contendo o valor da altura da coluna do corpo.
     */
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

    /**
     * Método responsável pela obtenção da instância do campo de entrada de dados.
     * @return Retorna a instância do campo de entrada de dados.
     */
    public TextField getFieldInput() { return fieldInput; }

    /**
     * Método responsável pela obtenção da instância do campo de saída de dados.
     * @return Retorna a instância do campo de saída de dados.
     */
    public TextField getFieldOutput() { return fieldOutput; }

    /**
     * Método responsável pela obtenção da instância do botão de requisição do cálculo do CRC.
     * @return Retorna a instância do botão de requisição do cálculo do CRC.
     */
    public Button getButtonCalculateCRC() { return buttonCalculateCRC; }
    public String getDataTypedByUser() { return dataTypedByUser; }
    public boolean isFieldInputClicked() { return isFieldInputClicked; }
    public boolean isButtonCalculateCrcClicked() { return isButtonCalculateCrcClicked; }

    /**
     * Método responsável pela composição principal da coluna do corpo.
     * @return Retorna a composição do corpo do algoritmo selecionado.
     */
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
        buttonCalculateCRC.setOnMouseClicked(
            mouseEvent -> {
                System.out.println("Button Calculate CRC was clicked.");
                this.isButtonCalculateCrcClicked = true;
                this.dataTypedByUser = this.fieldInput.getText();
            }
        );
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

    /**
     * Método responsável pela composição do cabeçalho informando o algoritmo selecionado.
     * @return Retorna a composição do cabeçalho de informação do algoritmo.
     */
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

    /**
     * Método responsável pela composição do grupo de entrada de dados.
     * @return Retorna a composição do grupo de entrada de dados.
     */
    private VBox createInputBox() {

        final VBox verticalInputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox inputSelectDataType = new ButtonGroupDataType().createGroupDataType("Input Field - ");

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

        fieldInput.setPrefWidth(300);
        fieldInput.setPrefHeight(25);
        fieldInput.setOnMouseClicked(
            mouseEvent -> {
                System.out.println("Field Input was clicked.");
                isFieldInputClicked = true;
            }
        );
        fieldInput.getStyleClass().add("style-field-input");

        verticalInputBox.getChildren().add(horizontalHeaderPane);
        verticalInputBox.getChildren().add(fieldInput);
        verticalInputBox.getChildren().add(inputSelectDataType);

        return verticalInputBox;
    }

    /**
     * Método responsável pela composição do grupo de saída de dados.
     * @return Retorna a composição do grupo de saída de dados.
     */
    private VBox createOutputBox() {

        final VBox verticalOutputBox = new VBox();
        final GridPane horizontalHeaderPane = new GridPane();
        final HBox outputSelectDataType = new ButtonGroupDataType().createGroupDataType("Output Field - ");

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

    /**
     * Método responsável pela composição do campo informativo sobre o algoritmo selecionado.
     * @return Retorna a composição do campo informativo sobre o algoritmo selecionado.
     */
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
