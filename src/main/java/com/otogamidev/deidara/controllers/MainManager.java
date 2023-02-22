package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.views.ScreenCalculation;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager {
    private ReceiveInputData receiveInputData;
    private SendOutputData sendOutputData;

    private final Stage stage = null;

    public Manager(final Stage stage) {
        initExecution(stage);
    }

    private static void initExecution(Stage stage) {
        try {
            final ScreenCalculation screenCalculation = new ScreenCalculation();
            screenCalculation.startScreenCalculation(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
