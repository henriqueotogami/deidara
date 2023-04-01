package com.otogamidev.deidara.models;

import com.otogamidev.deidara.controllers.SendOutputData;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

        final String rawInputMessage = "21 3B 00 FF";
        final String rawInputPoly = "BF 05";
        final String WHITESPACE = " ";
        final ArrayList<Integer> arrayRawIntegerMessage = new ArrayList<>();
        Integer[] sumAllBytes = new Integer[]{((Integer) 0)};
        int extractedSumAllBytes = 0;
        String binarySumAllBytes = "";
        final ArrayList<Integer> arrayRawPoly = new ArrayList<>();
        Integer[] arraySumPoly = new Integer[]{((Integer) 0)};
        int extractedPoly = 0;
        String binarySeparatedPoly = "";
        int leftBitShiftSumAllBytes = 0;
        String binaryLeftBitShiftSumAllBytes = "";
        if(rawInputMessage.contains(WHITESPACE)){
            System.out.println("CalculateCRC16 - main(): raw input message has a whitespace.");
            final ArrayList<String> arraySplitRawInMessage = new ArrayList<>(List.of(rawInputMessage.split(WHITESPACE, rawInputMessage.length())));
            System.out.println("CalculateCRC16 - main(): arraySplitRawInMessage.size() = " + arraySplitRawInMessage.size());
            arraySplitRawInMessage.forEach(splitByte -> arrayRawIntegerMessage.add(Integer.valueOf(splitByte,16)));
            System.out.println("CalculateCRC16 - main(): arrayRawIntegerMessage.size() = " + arrayRawIntegerMessage.size());
            arrayRawIntegerMessage.forEach(separatedByte -> sumAllBytes[0] += separatedByte);
            System.out.println("CalculateCRC16 - main(): sumAllBytes[0] = " + sumAllBytes[0]);
            extractedSumAllBytes = sumAllBytes[0].intValue();
            System.out.println("CalculateCRC16 - main(): extractedSumAllBytes = " + extractedSumAllBytes);
            binarySumAllBytes = Integer.toBinaryString(extractedSumAllBytes);
            System.out.println("CalculateCRC16 - main(): binarySumAllBytes = " + binarySumAllBytes);

            final ArrayList<String> arraySplitRawPoly = new ArrayList<>(List.of(rawInputPoly.split(WHITESPACE, rawInputPoly.length())));
            System.out.println("CalculateCRC16 - main(): arraySplitRawPoly.size() = " + arraySplitRawPoly.size());
            arraySplitRawPoly.forEach(splitPoly -> arrayRawPoly.add(Integer.valueOf(splitPoly, 16)));
            System.out.println("CalculateCRC16 - main(): arrayRawPoly.size() = " + arrayRawPoly.size());
            arrayRawPoly.forEach(separatedPoly -> arraySumPoly[0] += separatedPoly);
            System.out.println("CalculateCRC16 - main(): arraySumPoly[0] = " + arraySumPoly[0]);
            extractedPoly = arraySumPoly[0].intValue();
            System.out.println("CalculateCRC16 - main(): extractedPoly = " + extractedPoly);
            binarySeparatedPoly = Integer.toBinaryString(extractedPoly);
            System.out.println("CalculateCRC16 - main(): binarySeparatedPoly = " + binarySeparatedPoly);

            leftBitShiftSumAllBytes = (extractedSumAllBytes << binarySeparatedPoly.length());
            System.out.println("CalculateCRC16 - main(): leftBitShiftSumAllBytes = " + leftBitShiftSumAllBytes);
            binaryLeftBitShiftSumAllBytes = Integer.toBinaryString(leftBitShiftSumAllBytes);
            System.out.println("CalculateCRC16 - main(): binaryLeftBitShiftSumAllBytes = " + binaryLeftBitShiftSumAllBytes);

            int dividend = leftBitShiftSumAllBytes;
            int divisor = extractedPoly;
            int quocient  = 0;
            int remainder = 0;
            String binaryDividend = binaryLeftBitShiftSumAllBytes;
            String binaryDivisor = binarySeparatedPoly;
            String binaryQuocient = "";
            String binaryRemainder = null;
            String cuttingLeftBinaryDividend = null;
            int binaryDividendCutConvert = 0;
            int sizeBinaryDividend = binaryDividend.length();
            int sizeBinaryDivisor = binaryDivisor.length();
            final int cuttingBegin = 0;
            final int cuttingEnd = sizeBinaryDivisor;
            final int sizeLeftBitShiftSumAllBytes = binaryLeftBitShiftSumAllBytes.length();
            final ArrayList<Integer> storage = new ArrayList<>();
            for(int index = 0; sizeBinaryDividend > sizeBinaryDivisor; index++ ) {
                cuttingLeftBinaryDividend = binaryDividend.substring(cuttingBegin, cuttingEnd);
                System.out.println("CalculateCRC16 - main(): cuttingLeftBinaryDividend = " + cuttingLeftBinaryDividend);
                binaryDividendCutConvert = Integer.parseInt(cuttingLeftBinaryDividend, 2);
                System.out.println("CalculateCRC16 - main(): binaryDividendCutConvert = " + binaryDividendCutConvert);
                System.out.println("CalculateCRC16 - main(): divisor = " + divisor);
                remainder = (binaryDividendCutConvert ^ divisor);
                binaryDividend = binaryDividend.substring(cuttingEnd, sizeBinaryDividend);
                sizeBinaryDividend = binaryDividend.length();
                System.out.println("CalculateCRC16 - main(): index = " + index + " remainder = " + remainder);
                binaryRemainder = Integer.toBinaryString(remainder);
                System.out.println("CalculateCRC16 - main(): index = " + index + " binaryRemainder = " + binaryRemainder);
            }
            // todo: fazer o deslocamento a cada um bit e nao considerando o tamanho do polinomio
            System.out.println("CalculateCRC16 - main(): Final cuttingLeftBinaryDividend = " + cuttingLeftBinaryDividend);
            System.out.println("CalculateCRC16 - main(): Final binaryDividendCutConvert = " + binaryDividendCutConvert);

            System.out.println("CalculateCRC16 - main(): divisor = " + divisor);

            System.out.println("CalculateCRC16 - main(): Final remainder = " + remainder);
            System.out.println("CalculateCRC16 - main(): Final binaryRemainder = " + binaryRemainder);

        }

    }


}
