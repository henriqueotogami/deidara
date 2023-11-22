package com.otogamidev.deidara.models;

import java.math.BigInteger;
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
    final static int[] originalMessage = { 1,1,0,1,0,1,1,0,1,1 };
    final static int[] polynomial = { 1,0,0,1,1 };
    final static int augmentedMessageSize = (originalMessage.length + polynomial.length);
    final static int augmentedMessageRealSize = (augmentedMessageSize - 1);
    static int[] augmentedMessage = new int[augmentedMessageRealSize];
    private static int twoBitsXOR(final int firstBit, final int secondBit) {
        if(firstBit == secondBit) return 0;
        else return 1;
    }

    private static void increaseMessage() {
        for(int index = 0; augmentedMessageRealSize > index; index++) {
            if(originalMessage.length > index) {
                augmentedMessage[index] = originalMessage[index];
            } else {
                augmentedMessage[index] = 0;
            }
//            System.out.println("Index = " + index + " | augmentedMessage[index] = " + augmentedMessage[index]);
        }
    }

    private static void binaryDivision() {
        System.out.println("Original message   = " + Arrays.toString(originalMessage));
        System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
        System.out.println("Polynomial         = " + Arrays.toString(polynomial));

        final int[] firstRemainder = new int[polynomial.length];
        final int[] lastRemainder = new int[polynomial.length];
        final int[] quotient = new int[augmentedMessageSize];

        boolean makeQuotientXOR = false;
        boolean makeRemainderXOR = false;
        int messageIndex = 0;
        int countRemainder = 0;
        int displacement = 0;
        int quotientIndex = 0;
        int lastQuotient = 0;

        while(true) {
            System.out.println(" ");
            messageIndex = displacement;
            final int[] copyOfRange = Arrays.copyOfRange(augmentedMessage, displacement, augmentedMessageRealSize);
            System.out.println("Augmented message  = " + Arrays.toString(augmentedMessage));
            System.out.println("Shift message      = " + Arrays.toString(copyOfRange));

            for (int index = 0; firstRemainder.length > index; index++) {
                firstRemainder[index] = augmentedMessage[messageIndex];
            }
            System.out.println("First Remainder " + countRemainder + " = " + Arrays.toString(firstRemainder));

            final String regexRemoveAnyNotRange = "[^a-z0-1]";
            final String nothing = "";
            final String binaryRemainder = Arrays.toString(firstRemainder).replaceAll(regexRemoveAnyNotRange, nothing);
            System.out.println("binaryRemainder = " + binaryRemainder);

            final int decimalRemainder = Integer.parseInt(binaryRemainder, 2);
            System.out.println("decimalRemainder = " + decimalRemainder);

            final String binaryDivisor = Arrays.toString(polynomial).replaceAll(regexRemoveAnyNotRange, nothing);
            System.out.println("binaryDivisor = " + binaryDivisor);

            final int decimalDivisor = Integer.parseInt(binaryDivisor, 2);
            System.out.println("decimalDivisor = " + decimalDivisor);

            if(decimalDivisor > decimalRemainder) lastQuotient = 1;
            else lastQuotient = 0;

            quotient[quotientIndex] = lastQuotient;

            System.out.println("lastQuotient = " + lastQuotient);

            for (int index = 0; lastRemainder.length > index; index++) {
                final int eachBitRemainder = firstRemainder[index];
                lastRemainder[index] = twoBitsXOR(eachBitRemainder, lastQuotient);
            }
            System.out.println("Last Remainder " + countRemainder + " = " + Arrays.toString(lastRemainder));

            quotientIndex += 1;



            messageIndex = displacement;

            for (int remainderIndex = 0; firstRemainder.length > remainderIndex; remainderIndex++) {
                final int eachBitRemainder = firstRemainder[remainderIndex];
                final int eachBitFromMessage = augmentedMessage[messageIndex];
                firstRemainder[remainderIndex] = twoBitsXOR(eachBitRemainder, eachBitFromMessage);
                messageIndex += 1;
            }
            System.out.println("Second Remainder " + countRemainder + " = " + Arrays.toString(firstRemainder));

            if(messageIndex == (originalMessage.length)) break;

            displacement += 1;
            countRemainder += 1;
        }
    }

    public static void main(String[] args) {
        increaseMessage();
        binaryDivision();
    }
}
