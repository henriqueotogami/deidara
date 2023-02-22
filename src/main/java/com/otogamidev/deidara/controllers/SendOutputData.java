package com.otogamidev.deidara.controllers;

public class SendOutputData {
    private String parsedDataToSend = null;
    public SendOutputData(final String textReceivedOutputData) {
        System.out.println("SendOutputData: " + textReceivedOutputData);
        parsedDataToSend = textReceivedOutputData;
    }

    public void initSendParsedData(){
        System.out.println("SendOutputData - initSendParsedData(): BEGIN");

        System.out.println("SendOutputData - initSendParsedData(): END");
    }
}
