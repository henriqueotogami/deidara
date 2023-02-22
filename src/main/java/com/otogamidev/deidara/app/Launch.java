package com.otogamidev.deidara.app;

import com.otogamidev.deidara.controllers.MainManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(final Stage stage) {
        final MainManager manager = new MainManager(stage);
        manager.initExecution();
    }

    public static void main(String[] args) {
        launch();
    }
}