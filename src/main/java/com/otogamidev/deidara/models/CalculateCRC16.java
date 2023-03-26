package com.otogamidev.deidara.models;

import com.otogamidev.deidara.controllers.SendOutputData;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe responsável pelo recebimento de dados analisados e tratados pelas classes dos controladores,
 * pelo cálculo do CRC desses mesmos dados, e pelo envio dos dados calculados para a classe controladora
 * responsável pela saída de dados.
 * @author henriquematheusalvespereira
 * @since 22-02-2023
 */
public class CalculateCRC16 {

//    Atributor da classe CalculateCRC16
    private ArrayList dataInputParsedAndReady = null;
    private String dataOutputCalculated = null;

    private SendOutputData sendOutputData = null;

//    Métodos da classe CalculateCRC16

    /**
     * Método construtor da classe CalculateCRC16.
     * @param receivedDataParsed Instância contendo os dados analisados e tratados.
     */
    public CalculateCRC16(final ArrayList receivedDataParsed) {
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
//        System.out.println("CalculateCRC16 - execute() - dataInputParsedAndReady: ".concat(dataInputParsedAndReady));



        System.out.println("CalculateCRC16 - execute() - dataOutputCalculated: ".concat(dataOutputCalculated));
        System.out.println("CalculateCRC16 - execute(): END");
    }

    public static void main(String[] args) {
//        Entrada: 21000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//        Polinomio: 8005
//        Checksum: BB3D
//        CRC: 3428 -> 2834

//        Entrada: 213B00C4
//        Polinomio: 8005
//        Checksum: BB3D
//        CRC: 627A -> 7A62

        final String rawInputMessage = "21 3B 00 C4";
        final String rawInputPoly = "BF05";
        final String WHITESPACE = " ";
        final ArrayList<Byte> arrayRawInputMessage = new ArrayList<>();

        if(rawInputMessage.contains(WHITESPACE)){
            System.out.println("CalculateCRC16 - main(): raw input message has a whitespace.");
            final String[] arraySplitRawInMessage = rawInputMessage.split(WHITESPACE, rawInputMessage.length());
            System.out.println("CalculateCRC16 - main(): arraySplitRawInMessage.length " + arraySplitRawInMessage.length);
            arrayRawInputMessage.forEach(splitByte -> Byte.parseByte(arraySplitRawInMessage[splitByte]));
            System.out.println("CalculateCRC16 - main(): arrayRawInputMessage.size() " + arrayRawInputMessage.size());
            final Iterator<Byte> iterator = arrayRawInputMessage.iterator();
            while(iterator.hasNext()){
                System.out.println("CalculateCRC16 - main(): arrayRawInputMessage[next] = " + Long.toHexString(Byte.toUnsignedLong(iterator.next())));
            }
        }

    }


}
