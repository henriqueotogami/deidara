package com.otogamidev.deidara.models;

import com.otogamidev.deidara.controllers.SendOutputData;

/**
 * Classe responsável pelo recebimento de dados analisados e tratados pelas classes dos controladores,
 * pelo cálculo do CRC desses mesmos dados, e pelo envio dos dados calculados para a classe controladora
 * responsável pela saída de dados.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class CalculateCRC16 {

//    Atributor da classe CalculateCRC16
    private String dataInputParsedAndReady = null;
    private String dataOutputCalculated = null;

    private SendOutputData sendOutputData = null;

//    Métodos da classe CalculateCRC16

    /**
     * Método construtor da classe CalculateCRC16.
     * @param receivedDataParsed Instância contendo os dados analisados e tratados.
     */
    public CalculateCRC16(final String receivedDataParsed) {
        dataInputParsedAndReady = receivedDataParsed;
    }

    /**
     * Método responsável pela obtenção dos dados calculados.
     * @return Retorna o resultado do cálculo do CRC.
     */
    public String getDataOutputCalculated() {
        return dataOutputCalculated;
    }

    /**
     * Método responsável pela inicialização do cálculo do CRC.
     */
    public void execute() {
        System.out.println("CalculateCRC16 - execute(): BEGIN");
        System.out.println("CalculateCRC16 - execute() - dataInputParsedAndReady: ".concat(dataInputParsedAndReady));



        System.out.println("CalculateCRC16 - execute() - dataOutputCalculated: ".concat(dataOutputCalculated));
        System.out.println("CalculateCRC16 - execute(): END");
    }


}
