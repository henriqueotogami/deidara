package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.models.CalculateCRC16;

/**
 * Classe responsável pela recepção dos dados fornecidos pelo usuário ao gerenciador principal dos controladores.
 * Os dados serão analisados e tratados, para serem enviados para a classe modelo de cálculo de CRC.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class ReceiveInputData {

//    Atributos da classe ReceiveInputData
    private String receivedDataToParser = null;
    private CalculateCRC16 calculateCRC16 = null;

//    Métodos da classe ReceiveInputData

    /**
     * Método construtor da classe ReceiveInputData.
     * @param textReceivedInputData Instância contendo os dados a serem analisados e tratados.
     */
    public ReceiveInputData(final String textReceivedInputData) {
        System.out.println("ReceiveInputData: " + textReceivedInputData);
        receivedDataToParser = textReceivedInputData;
    }

    /**
     * Método responsável pela inicialização da análise dos dados recebidos.
     */
    public void initParserReceivedData(){
        System.out.println("ReceiveInputData - parserReceivedData(): BEGIN");
        if(receivedDataToParser != null){
            calculateCRC16 = new CalculateCRC16(receivedDataToParser);
            calculateCRC16.execute();
        }
        System.out.println("ReceiveInputData - parserReceivedData(): END");
    }

}
