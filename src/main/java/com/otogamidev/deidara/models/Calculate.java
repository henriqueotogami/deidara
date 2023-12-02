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
    final static int augmentedMessageSize = (originalMessage.length + polynomial.length);
    final static int augmentedMessageRealSize = (augmentedMessageSize - 1);
    static int[] augmentedMessage = new int[augmentedMessageRealSize];
    final static int[] lastRemainder = new int[polynomial.length];

    public Calculate(final int[] originalMessage, final int[] polynomial) {
        this.originalMessage = originalMessage;
        this.polynomial = polynomial;
    }

    public int[] getLastRemainder() { return lastRemainder; }

    private static int twoBitsXOR(final int firstBit, final int secondBit) {
        if(firstBit == secondBit) return 0;
        else return 1;
    }

    private static int multiplyTwoBits(final int firstBit, final int secondBit) {
        if(firstBit == 0 || secondBit == 0) return 0;
        else return 1;
    }

    private static void increaseMessage() {
        for(int index = 0; augmentedMessageRealSize > index; index++) {
            if(originalMessage.length > index) {
                augmentedMessage[index] = originalMessage[index];
            } else {
                augmentedMessage[index] = 0;
            }
        }
    }

    private static void binaryDivision() {
        System.out.println("Original message   = " + Arrays.toString(originalMessage));
        System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
        System.out.println("Polynomial         = " + Arrays.toString(polynomial));

        final int[] firstRemainder  = new int[polynomial.length];
        final int[] quotient        = new int[augmentedMessageSize];

        int messageIndex = 0;
        int countRemainder = 0;
        int displacement = polynomial.length;
        int quotientIndex = 0;
        int lastQuotient = 0;

        for (int index = 0; firstRemainder.length > index; index++) {
            firstRemainder[index] = augmentedMessage[index];
        }

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


    public static void main(String[] args) {
        increaseMessage();
        binaryDivision();
    }

    public void start() {
        increaseMessage();
        binaryDivision();
    }
}
