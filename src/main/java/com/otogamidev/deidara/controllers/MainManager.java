package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.views.ScreenCalculation;
import javafx.stage.Stage;

import java.io.IOException;

public class MainManager extends Thread {
    private ReceiveInputData receiveInputData;
    private SendOutputData sendOutputData;

    private static Stage stage = null;

    private static boolean isRunning = false;

    private static final ScreenCalculation screenCalculation = new ScreenCalculation();

    public MainManager(final Stage stage) {
        this.stage = stage;
    }

    public boolean isRunning() { return isRunning; }

    public void initExecution() {
        try {
            System.out.println("MainManager - initExecution(): BEGIN");
            screenCalculation.startScreenCalculation(stage);
            isRunning = true;
            this.start();
        } catch (IOException ioException) {
            isRunning = false;
            throw new RuntimeException(ioException);
        } finally {
            System.out.println("MainManager - initExecution(): END");
        }
    }

    @Override
    public void run() {
        while(isRunning) {
//            System.out.println("MainManager - run(): BEGIN");
            final boolean isPressedButtonCalculate = screenCalculation.getAlgorithmBody().getButtonCalculateCRC().isPressed();
            if(isPressedButtonCalculate) {
                final String textInputData = screenCalculation.getAlgorithmBody().getFieldInput().getText();
                System.out.println("MainManager - run() - textInputData: ".concat(textInputData));
                receiveInputData = new ReceiveInputData(textInputData);
                receiveInputData.initParserReceivedData();
                break;
            }
//            System.out.println("MainManager - run(): END");
            try {
                this.sleep(1000);
            } catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
        }
    }
}
