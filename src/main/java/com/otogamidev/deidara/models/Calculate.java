package com.otogamidev.deidara.models;

import java.util.Arrays;

public class Calculate {

//    Um resumo da operação da classe de algoritmos CRC:
//            1. Escolha uma largura W e um poli G (de largura W).
//            2. Anfit W zero bits à mensagem. Chame isso de M’.
//            3. Divida M' por G usando a aritmética CRC. O restante é a soma de verificação.

//            0 + 0 = 0
//            0 + 1 = 1
//            1 + 0 = 1
//            1 + 1 = 0 (sem transferência)


//    1 - Recorto o dividendo da esquerda pra direita, com o mesmo tamanho que o divisor, e salvo como
//    primeiro resto

//    2 - Verifico se o valor em decimal do primeiro resto é maior que o quociente
//            Defino valor 1 para o quociente se o quociente for maior
//            Defino valor 0 para o quociente se o quociente for menor

//    3 - Multiplico o quociente pelo divisor e salvo como o último resto

//    4 - Aplico XOR entre o primeiro e o último resto e salvo o valor no primeiro resto

//    5 - Desço o bit mais próximo da direita e salvo no primeiro resto

//    6 - Verifico se chegou no último bit do dividendo
//        Se sim, retorno o valor do último resto
//        Se não, continua a partir da etapa 2
    static int[] originalMessage;
    static int[] polynomial;
    static int[] augmentedMessage;
    static int[] lastRemainder;
    static int augmentedMessageSize;
    static int augmentedMessageRealSize;

    public Calculate(final int[] originalMessage, final int[] polynomial) {
        this.originalMessage = originalMessage;
        this.polynomial = polynomial;
        this.augmentedMessageSize = (originalMessage.length + polynomial.length);
        this.augmentedMessageRealSize = (augmentedMessageSize - 1);
        this.augmentedMessage = new int[augmentedMessageRealSize];
        this.lastRemainder = new int[polynomial.length];
    }

    public int[] getLastRemainder() { return lastRemainder; }

    private static int twoBitsXOR(final int firstBit, final int secondBit) {
        return (firstBit == secondBit) ? 0 : 1;
    }

    private static int multiplyTwoBits(final int firstBit, final int secondBit) {
        return (firstBit == 0 || secondBit == 0) ? 0 : 1;
    }

    private static void increaseMessage() {
        for(int index = 0; augmentedMessageRealSize > index; index++) {
            augmentedMessage[index] = (originalMessage.length > index) ? originalMessage[index] : 0;
        }
    }

    private static void binaryDivision() {
        System.out.println("Original message   = " + Arrays.toString(originalMessage));
        System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
        System.out.println("Polynomial         = " + Arrays.toString(polynomial));

        final int[] firstRemainder  = Arrays.copyOfRange(augmentedMessage, 0, polynomial.length);
        final int[] quotient        = new int[augmentedMessageSize];

        int countRemainder = 0;
        int displacement = polynomial.length;
        int quotientIndex = 0;
        int lastQuotient = 0;


        while(augmentedMessageSize >= displacement) {
            System.out.println(" ");
            System.out.println("First Remainder " + countRemainder + "     = " + Arrays.toString(firstRemainder));

            final String regexRemoveAnyNotRange = "[^a-z0-1]";
            final String nothing = "";
            final String binaryFirstRemainder = Arrays.toString(firstRemainder).replaceAll(regexRemoveAnyNotRange, nothing);

            final int decimalFirstRemainder = Integer.parseInt(binaryFirstRemainder, 2);

            final String binaryDivisor = Arrays.toString(polynomial).replaceAll(regexRemoveAnyNotRange, nothing);
            final int decimalDivisor = Integer.parseInt(binaryDivisor, 2);

            if(decimalFirstRemainder >= decimalDivisor) lastQuotient = 1;
            else lastQuotient = 0;

            quotient[quotientIndex] = lastQuotient;

            for (int index = 0; lastRemainder.length > index; index++) {
                final int eachBitPolynomial = polynomial[index];
                if(lastQuotient == 1) lastRemainder[index] = eachBitPolynomial;
                else lastRemainder[index] = 0;
            }
            System.out.println("Last Remainder " + countRemainder + "      = " + Arrays.toString(lastRemainder));

            for(int index = 0; lastRemainder.length > index; index++) {
                final int eachBitFirstRemainder = firstRemainder[index];
                final int eachBitLastRemainder = lastRemainder[index];
                lastRemainder[index] = twoBitsXOR(eachBitFirstRemainder, eachBitLastRemainder);
            }

            if(augmentedMessageRealSize > displacement) {
                for (int index = 0, indexx = 1; firstRemainder.length > index; index++, indexx++) {
                    if ((firstRemainder.length - 1) == index)
                        firstRemainder[index] = augmentedMessage[displacement];
                    else
                        firstRemainder[index] = lastRemainder[indexx];
                }
            }
            quotientIndex += 1;
            displacement += 1;
            countRemainder += 1;
        }
        System.out.println(" ");
        System.out.println("Original message   = " + Arrays.toString(originalMessage));
        System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
        System.out.println("Polynomial         = " + Arrays.toString(polynomial));
        System.out.println("CRC calculated     = " + Arrays.toString(lastRemainder));
    }

    private int binaryArrayToDecimal(final int[] binaryArray) {
        final StringBuilder binaryStringBuilder = new StringBuilder();
        for (int bit : binaryArray) binaryStringBuilder.append(bit);
        return Integer.parseInt(binaryStringBuilder.toString(), 2);
    }

    private void shiftArrayLeft(final int[] array) {
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = augmentedMessage[augmentedMessageRealSize - augmentedMessageSize + 1];
    }

//    private void binaryDivision() {
//        System.out.println("Original message   = " + Arrays.toString(originalMessage));
//        System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
//        System.out.println("Polynomial         = " + Arrays.toString(polynomial));
//
//        int[] firstRemainder = Arrays.copyOfRange(augmentedMessage, 0, polynomial.length);
//        int[] quotient = new int[augmentedMessageSize];
//
//        int quotientIndex = 0;
//
//        while (augmentedMessageSize >= polynomial.length) {
//            System.out.println(" ");
//            System.out.println("First Remainder     = " + Arrays.toString(firstRemainder));
//
//            int decimalFirstRemainder = binaryArrayToDecimal(firstRemainder);
//            int decimalDivisor = binaryArrayToDecimal(polynomial);
//
//            int lastQuotient = (decimalFirstRemainder >= decimalDivisor) ? 1 : 0;
//            quotient[quotientIndex] = lastQuotient;
//
//            Arrays.fill(lastRemainder, 0);
//
//            for (int i = 0; i < polynomial.length; i++) {
//                lastRemainder[i] = lastQuotient * polynomial[i];
//            }
//
//            System.out.println("Last Remainder      = " + Arrays.toString(lastRemainder));
//
//            for (int i = 0; i < lastRemainder.length; i++) {
//                firstRemainder[i] = twoBitsXOR(firstRemainder[i], lastRemainder[i]);
//            }
//
//            shiftArrayLeft(firstRemainder);
//
//            augmentedMessageSize--;
//            quotientIndex++;
//        }
//
//        System.out.println(" ");
//        System.out.println("CRC calculated      = " + Arrays.toString(lastRemainder));
//    }
//
//    private int binaryArrayToDecimal(int[] binaryArray) {
//        StringBuilder binaryStringBuilder = new StringBuilder();
//        for (int bit : binaryArray) {
//            binaryStringBuilder.append(bit);
//        }
//        return Integer.parseInt(binaryStringBuilder.toString(), 2);
//    }
//
//    private void shiftArrayLeft(int[] array) {
//        System.arraycopy(array, 1, array, 0, array.length - 1);
//        array[array.length - 1] = augmentedMessage[augmentedMessageRealSize - augmentedMessageSize + 1];
//    }


    public static void main(String[] args) {
        increaseMessage();
        binaryDivision();
    }

    public void start() {
        increaseMessage();
        binaryDivision();
    }

//    import java.util.Arrays;
//
//    public class CRC16Calculator {
//
//        private static final int CRC16_POLYNOMIAL = 0x1021;
//        private static final int CRC16_INITIAL_VALUE = 0xFFFF;
//
//        public static int calculateCRC16(byte[] data) {
//            int crc = CRC16_INITIAL_VALUE;
//
//            for (byte b : data) {
//                crc ^= (b & 0xFF) << 8;
//
//                for (int i = 0; i < 8; i++) {
//                    if ((crc & 0x8000) != 0) {
//                        crc = (crc << 1) ^ CRC16_POLYNOMIAL;
//                    } else {
//                        crc <<= 1;
//                    }
//                }
//            }
//
//            return crc & 0xFFFF;
//        }
//
//        public static void main(String[] args) {
//            // Exemplo de uso:
//            byte[] data = "Hello, CRC-16!".getBytes();
//            int crc16 = calculateCRC16(data);
//
//            System.out.println("Data: " + Arrays.toString(data));
//            System.out.printf("CRC-16: 0x%04X\n", crc16);
//        }
//    }

}
