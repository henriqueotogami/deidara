package com.otogamidev.deidara.controllers;

import com.otogamidev.deidara.models.CalculateCRC16;

public class ReceiveInputData {

    private String receivedDataToParser = null;
    private CalculateCRC16 calculateCRC16 = null;
    public ReceiveInputData(final String textReceivedInputData) {
        System.out.println("ReceiveInputData: " + textReceivedInputData);
        receivedDataToParser = textReceivedInputData;
    }

    public void initParserReceivedData(){
        System.out.println("ReceiveInputData - parserReceivedData(): BEGIN");
        if(receivedDataToParser != null){
            calculateCRC16 = new CalculateCRC16(receivedDataToParser);
            calculateCRC16.execute();
        }
        System.out.println("ReceiveInputData - parserReceivedData(): END");
    }

}
