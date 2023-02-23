package com.otogamidev.deidara.controllers;

/**
 * Classe responsável pela recepção dos dados calculados pela classe modelo de cálculo do CRC.
 * Os dados serão analisados e formatados, para serem enviados para a classe do gerenciador principal da aplicação.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class SendOutputData {

//    Atributos da classe SendOutputData
    private String parsedDataToSend = null;

//    Métodos da classe SendOutputData

    /**
     * Método construtor da classe SendOutputData.
     * @param textReceivedOutputData Instância contendo os dados para serem analisados e formatados.
     */
    public SendOutputData(final String textReceivedOutputData) {
        System.out.println("SendOutputData: " + textReceivedOutputData);
        parsedDataToSend = textReceivedOutputData;
    }

    /**
     * Método responsável por inicializar a análise dos dados.
     */
    public void initSendParsedData(){
        System.out.println("SendOutputData - initSendParsedData(): BEGIN");

        System.out.println("SendOutputData - initSendParsedData(): END");
    }
}
