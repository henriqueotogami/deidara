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

        final int[] firstRemainder  = new int[polynomial.length];
        final int[] lastRemainder   = new int[polynomial.length];
        final int[] quotient        = new int[augmentedMessageSize];

        int messageIndex = 0;
        int countRemainder = 0;
        int displacement = 0;
        int quotientIndex = 0;
        int lastQuotient = 0;

//    1 - Recorto o dividendo da esquerda pra direita, com o mesmo tamanho que o divisor, e salvo como
//    primeiro resto
        for (int index = 0; firstRemainder.length > index; index++) {
            firstRemainder[index] = augmentedMessage[index];
        }

        while(true) {
            System.out.println(" ");
            messageIndex = displacement;
            System.out.println("Augmented message     = " + Arrays.toString(augmentedMessage));
            System.out.println("First Remainder " + countRemainder + "     = " + Arrays.toString(firstRemainder));

            final String regexRemoveAnyNotRange = "[^a-z0-1]";
            final String nothing = "";
            final String binaryRemainder = Arrays.toString(firstRemainder).replaceAll(regexRemoveAnyNotRange, nothing);
//            System.out.println("binaryRemainder = " + binaryRemainder);

            final int decimalRemainder = Integer.parseInt(binaryRemainder, 2);
//            System.out.println("decimalRemainder = " + decimalRemainder);

            final String binaryDivisor = Arrays.toString(polynomial).replaceAll(regexRemoveAnyNotRange, nothing);
//            System.out.println("binaryDivisor = " + binaryDivisor);

            final int decimalDivisor = Integer.parseInt(binaryDivisor, 2);
//            System.out.println("decimalDivisor = " + decimalDivisor);

//    2 - Verifico se o valor em decimal do primeiro resto é maior que o quociente
//            Defino valor 1 para o quociente se o quociente for maior
//            Defino valor 0 para o quociente se o quociente for menor
            if(decimalDivisor > decimalRemainder) lastQuotient = 1;
            else lastQuotient = 0;

            quotient[quotientIndex] = lastQuotient;
//            System.out.println("lastQuotient = " + lastQuotient);

//    3 - Multiplico o quociente pelo divisor e salvo como o último resto
            for (int index = 0; lastRemainder.length > index; index++) {
                final int eachBitRemainder = firstRemainder[index];
                lastRemainder[index] = twoBitsXOR(eachBitRemainder, lastQuotient);
            }
            System.out.println("Last Remainder " + countRemainder + "      = " + Arrays.toString(lastRemainder));

//    4 - Aplico XOR entre o primeiro e o último resto e salvo o valor no primeiro resto
            for (int index = 0; lastRemainder.length > index; index++) {
                final int eachBitFirstRemainder = firstRemainder[index];
                final int eachBitLastRemainder = lastRemainder[index];
                firstRemainder[index] = twoBitsXOR(eachBitFirstRemainder, eachBitLastRemainder);
            }
            System.out.println("XOR First Remainder " + countRemainder + " = " + Arrays.toString(firstRemainder));

//    5 - Desço o bit mais próximo da direita e salvo no primeiro resto
            for(int index = 0; firstRemainder.length > index; index++) {
                if((firstRemainder.length-1) == index)
                    firstRemainder[index] = augmentedMessage[displacement];
                else
                    firstRemainder[index] = firstRemainder[index+1];
            }
//            System.out.println("New First Remainder " + countRemainder + " = " + Arrays.toString(firstRemainder));

//    6 - Verifico se chegou no último bit do dividendo
//        Se sim, retorno o valor do último resto
//        Se não, continua a partir da etapa 2
            if(displacement == (originalMessage.length)) break;

            quotientIndex += 1;
            displacement += 1;
            countRemainder += 1;
        }
    }

    public static void main(String[] args) {
        increaseMessage();
        binaryDivision();
    }
}
