package com.otogamidev.deidara.views;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * Classe responsável pela composição do grupo de botões de seleção do tipo de dado exibido nos campos de entrada e saída.
 * @author henriquematheusalvespereira
 * @since 01-03-2023
 */
public class ButtonGroupDataType {

//    Atributos da classe ButtonGroupDataType

    private static ToggleGroup toggleGroup = null;
    private static RadioButton buttonASCII = null;
    private static RadioButton buttonHex = null;
    private static RadioButton buttonDec = null;
    private static RadioButton buttonOct = null;
    private static RadioButton buttonBin = null;
    private static boolean isButtonASCIIClicked = false;
    private static boolean isButtonHexClicked = false;
    private static boolean isButtonOctClicked = false;
    private static boolean isButtonDecClicked = false;
    private static boolean isButtonBinClicked = false;

    public boolean isButtonASCIIClicked() { return isButtonASCIIClicked; }

    public boolean isButtonHexClicked() { return isButtonHexClicked; }

    public boolean isButtonOctClicked() { return isButtonOctClicked; }

    public boolean isButtonDecClicked() { return isButtonDecClicked; }

    public boolean isButtonBinClicked() { return isButtonBinClicked; }

//    Métodos da classe ButtonGroupDataType

    public ButtonGroupDataType() {

    }

    /**
     * Método responsável pela composição do conjunto de botões de seleção do tipo de dados visualizado.
     * @param originRequest Indica se a requisição de tipo de dados foi realizada no campo de entrada ou saída.
     * @return Retorna a composição do conjunto de botões de seleção do tipo de dados visualizado.
     */
    public static HBox createGroupDataType(final String originRequest) {

        toggleGroup = new ToggleGroup();
        buttonASCII = new RadioButton("ASCII");
        buttonHex = new RadioButton("HEX");
        buttonDec = new RadioButton("DEC");
        buttonOct = new RadioButton("OCT");
        buttonBin = new RadioButton("BIN");

        buttonASCII.setToggleGroup(toggleGroup);
        buttonHex.setToggleGroup(toggleGroup);
        buttonDec.setToggleGroup(toggleGroup);
        buttonOct.setToggleGroup(toggleGroup);
        buttonBin.setToggleGroup(toggleGroup);

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

        final int indexButtonASCII = 0;
        final int indexButtonHex = 1;
        final int indexButtonDec = 2;
        final int indexButtonOct = 3;
        final int indexButtonBin = 4;

        buttonASCII.setOnMouseClicked(
                mouseEvent -> {
                    System.out.println(originRequest.concat("Button ASCII was clicked."));
                    defineOnlyOneButtonClicked(indexButtonASCII);
                }
        );

        buttonHex.setOnMouseClicked(
                mouseEvent -> {
                    System.out.println(originRequest.concat("Button Hex was clicked."));
                    defineOnlyOneButtonClicked(indexButtonHex);
                }
        );

        buttonDec.setOnMouseClicked(
                mouseEvent -> {
                    System.out.println(originRequest.concat("Button Dec was clicked."));
                    defineOnlyOneButtonClicked(indexButtonDec);
                }
        );

        buttonOct.setOnMouseClicked(
                mouseEvent -> {
                    System.out.println(originRequest.concat("Button Oct was clicked."));
                    defineOnlyOneButtonClicked(indexButtonOct);
                }
        );

        buttonBin.setOnMouseClicked(
                mouseEvent -> {
                    System.out.println(originRequest.concat("Button Bin was clicked."));
                    defineOnlyOneButtonClicked(indexButtonBin);
                }
        );

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

    /**
     * Método responsável por definir apenas uma variável boolean que indica qual botão foi pressionado.
     * @param indexButton Índice do botão (0 a 4).
     */
    private static void defineOnlyOneButtonClicked(final int indexButton) {

        isButtonASCIIClicked = false;
        isButtonHexClicked = false;
        isButtonDecClicked = false;
        isButtonOctClicked = false;
        isButtonBinClicked = false;

        switch(indexButton) {
            case 0:
                isButtonASCIIClicked = true;
            case 1:
                isButtonHexClicked = true;
            case 2:
                isButtonDecClicked = true;
            case 3:
                isButtonOctClicked = true;
            case 4:
                isButtonBinClicked = true;
        }
    }

}
