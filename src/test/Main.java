public class Main {

//    1 - Transformar dados em sequência de bits
//    2 - Acrescentar a quantidade de zeros do lado direito do pacote de dados
//    3 - Armazenar a sequência de bits representando o pacote do Gerador
//    4 - Dividir o pacote de dados pelo pacote do gerador
//    5 - Realizar a lógica XOR entre o Dividendo e o Resto
    private static final String stringInputPacket = "21000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    private static int[] arrayDecBytesPacket;

    private static String[] arrayDecBitStringPacket;

    private static final String hexGeneratorPolynomial = "8005";

    public static void main(String[] args) {

        final int stringInputLength = stringInputPacket.length();
        convertInputToBitsSequence(stringInputLength);


    }

    private static void convertInputToBitsSequence(final int stringBytesInputLength) {

        arrayDecBytesPacket = new int[(stringBytesInputLength/2)];

        int arrayIndex = 0;
        int startIndex = 0;
        int endIndex = 2;
        int byteDecSubstring;
        String byteHexSubstring;
        while(stringBytesInputLength >= (startIndex+2)) {
            byteHexSubstring = stringInputPacket.substring(startIndex,endIndex);
            byteDecSubstring = Integer.parseInt(byteHexSubstring,16);
            arrayDecBytesPacket[arrayIndex] = byteDecSubstring;
            System.out.println("arrayStringBytesPacket[" + arrayIndex + "] = " + arrayDecBytesPacket[arrayIndex]);
            arrayIndex++;
            startIndex+=2;
            endIndex+=2;
        }

        arrayDecBitStringPacket = new String[stringBytesInputLength/2];
        arrayIndex = 0;
        String bytesToBitsSequence;

        while((arrayDecBitStringPacket.length-1) >= arrayIndex) {
            bytesToBitsSequence = Integer.toBinaryString(arrayDecBytesPacket[arrayIndex]);
            arrayDecBitStringPacket[arrayIndex] = bytesToBitsSequence;
//            System.out.println("arrayDecBitStringPacket[" + arrayIndex + "] = " + arrayDecBitStringPacket[arrayIndex]);
            arrayIndex++;
        }

        arrayIndex = 0;
        String bitSequence;
        while((arrayDecBitStringPacket.length-1) >= arrayIndex){
            bitSequence = arrayDecBitStringPacket[arrayIndex];
            while (16 > bitSequence.length()) {
                bitSequence = "0" + bitSequence;
            }
            bitSequence = "0x" + bitSequence;
            arrayDecBitStringPacket[arrayIndex] = bitSequence;
            System.out.println("arrayDecBitStringPacket[" + arrayIndex + "] = " + arrayDecBitStringPacket[arrayIndex]);
            arrayIndex++;
        }

        System.out.println("Generator: " + Integer.toBinaryString(Integer.parseInt(hexGeneratorPolynomial,16)));
    }
}