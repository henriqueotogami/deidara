package com.otogamidev.deidara.app;

import com.otogamidev.deidara.controllers.MainManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe responsável por inicializar a aplicação, instanciando o gerenciador principal dos controladores.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 * @see javafx.application.Application
 */
public class Launch extends Application {

    /**
     * Método responsável por inicializar a execução do gerenciador principal dos controladores da aplicação.
     * @param stage Instância da janela principal
     */
    @Override
    public void start(final Stage stage) {
        final MainManager manager = new MainManager(stage);
        manager.initExecution();
    }

    /**
     * Método responsável por invocar a aplicação.
     * @param args Instância padrão do método main.
     */
    public static void main(String[] args) {
        launch();
    }
}