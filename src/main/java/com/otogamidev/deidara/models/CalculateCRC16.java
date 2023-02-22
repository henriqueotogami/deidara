package com.otogamidev.deidara.models;

import com.otogamidev.deidara.controllers.SendOutputData;

public class CalculateCRC16 {

    private String dataInputParsedAndReady = null;
    private String dataOutputCalculated = null;

    private SendOutputData sendOutputData = null;
    public CalculateCRC16(final String receivedDataParsed) {
        dataInputParsedAndReady = receivedDataParsed;
    }

    public String getDataOutputCalculated() {
        return dataOutputCalculated;
    }

    public void execute() {
        System.out.println("CalculateCRC16 - execute(): BEGIN");
        System.out.println("CalculateCRC16 - execute() - dataInputParsedAndReady: ".concat(dataInputParsedAndReady));



        System.out.println("CalculateCRC16 - execute() - dataOutputCalculated: ".concat(dataOutputCalculated));
        System.out.println("CalculateCRC16 - execute(): END");
    }


}
