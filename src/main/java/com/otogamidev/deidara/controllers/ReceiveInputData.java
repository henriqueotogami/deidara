package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.models.CalculateCRC16;

import java.util.ArrayList;

/**
 * Classe responsável pela recepção dos dados fornecidos pelo usuário ao gerenciador principal dos controladores.
 * Os dados serão analisados e tratados, para serem enviados para a classe modelo de cálculo de CRC.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class ReceiveInputData {

//    Atributos da classe ReceiveInputData
    private String receivedDataToParser = null;
    private int indexButtonSelected = 0;
    private ArrayList<Byte> separatedBytesFromReceived = new ArrayList();
    private CalculateCRC16 calculateCRC16 = null;

//    Métodos da classe ReceiveInputData

    /**
     * Método construtor da classe ReceiveInputData.
     * @param textReceivedInputData Instância contendo os dados a serem analisados e tratados.
     * @param indexButtonSelected Intância contendo o índice que indica o tipo de dado informado.
     */
    public ReceiveInputData(final String textReceivedInputData, final int indexButtonSelected) {
        System.out.println("ReceiveInputData: " + textReceivedInputData);
        this.receivedDataToParser = textReceivedInputData;
        this.indexButtonSelected = indexButtonSelected;
    }

    /**
     * Método responsável pela inicialização da análise dos dados recebidos.
     */
    public void initParserReceivedData(){
        System.out.println("ReceiveInputData - parserReceivedData(): BEGIN");
        if(receivedDataToParser != null){
            int indexBegin = 0;
            int indexEnd = 2;
            final int sizeToIterateReceivedData = (receivedDataToParser.length()-2);
            for(int index = 0; (sizeToIterateReceivedData > index); index++) {
                final String substringByes = receivedDataToParser.substring(indexBegin, indexEnd);
                final byte convertedBytes = Byte.parseByte(substringByes);
                separatedBytesFromReceived.add(convertedBytes);
                indexBegin++;
                indexEnd++;
            }

            calculateCRC16 = new CalculateCRC16(separatedBytesFromReceived);
            calculateCRC16.execute();
        }
        System.out.println("ReceiveInputData - parserReceivedData(): END");
    }

}
