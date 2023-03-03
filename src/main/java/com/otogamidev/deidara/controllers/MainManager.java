package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.views.ScreenCalculation;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe responsável pelo gerenciamento de todos os controladores da aplicação.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 * @see java.lang.Thread
 */
public class MainManager extends Thread {

//    Atributos da classe MainManager
    private ReceiveInputData receiveInputData;
    private SendOutputData sendOutputData;

    private static Stage stage = null;

    private static boolean isRunning = false;

    private static final ScreenCalculation screenCalculation = new ScreenCalculation();

//    Métodos da classe MainManager

    /**
     * Método construtor da classe MainManager.
     * @param stage Instância da janela principal da aplicação.
     */
    public MainManager(final Stage stage) {
        this.stage = stage;
    }

    public MainManager(){
        super();
    }

    /**
     * Método responsável por indicar se a aplicação está executando.
     * @return Valor true indicando execução ou valor false indicando pausa.
     */
    public boolean isRunning() { return isRunning; }

    /**
     * Método responsável pela inicialização da execução da aplicação.
     */
    public void initExecution() {
        try {
            System.out.println("MainManager - initExecution(): BEGIN");
            screenCalculation.startScreenCalculation(stage);
            isRunning = true;
            this.start();
        } catch (final IOException ioException) {
            isRunning = false;
            throw new RuntimeException(ioException);
        } finally {
            System.out.println("MainManager - initExecution(): END");
        }
    }

    /**
     * Método responsável por inicializar a execução da Thread do gerenciador principal da aplicação.
     */
    @Override
    public void run() {
        while(isRunning) {
//            System.out.println("MainManager - run(): BEGIN");
            final boolean isPressedButtonCalculate = screenCalculation.getAlgorithmBody().isButtonCalculateCrcClicked();
            if(isPressedButtonCalculate) {
                final String textInputData = screenCalculation.getAlgorithmBody().getDataTypedByUser();
                final int indexButtonSelected = screenCalculation.getAlgorithmBody().getIndexButtonFieldInputWasClicked();
                System.out.println("MainManager - run() - textInputData: ".concat(textInputData));
                receiveInputData = new ReceiveInputData(textInputData, indexButtonSelected);
                receiveInputData.initParserReceivedData();
                break;
            }
//            System.out.println("MainManager - run(): END");
            try {
                this.sleep(1000);
            } catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
            continue;
        }
    }
}
