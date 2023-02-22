package com.otogamidev.deidara.controller;

import com.otogamidev.deidara.view.ScreenCalculation;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenCalculation extends Application {

    private ReceiveInputData receiveInputData;
    private SendOutputData sendOutputData;

    @Override
    public void start(final Stage stage) throws IOException {
        final ScreenCalculation screenCalculation = new ScreenCalculation();
        screenCalculation.startScreenCalculation(stage);
    }

    public static void main(String[] args) {

        launch();


    }
}