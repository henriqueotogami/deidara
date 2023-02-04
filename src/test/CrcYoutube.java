import java.util.Scanner;

public class CrcYoutube {

    public static String crc(String dividend, String divisor) {

        String str2;
        String div;
        String binaryStringDividend=dividend;
        int shift = (dividend.length()-divisor.length());
        System.out.println("crc(): shift=".concat(String.valueOf(shift)));

        while(shift>=0) {
            int divisorBinary = Integer.parseInt(divisor, 2) << shift;
            int dividendBinary = Integer.parseInt(binaryStringDividend, 2);
            binaryStringDividend=Integer.toBinaryString(Integer.parseInt(binaryStringDividend, 2)^Integer.parseInt(divisor, 2)<<shift);
            shift=binaryStringDividend.length()-divisor.length();

        }

        System.out.println("crc(): dividend=".concat(binaryStringDividend));
        if(binaryStringDividend.length()<16) {
            while(binaryStringDividend.length()!=16){
                binaryStringDividend="0"+binaryStringDividend;
                System.out.println("crc(): adding left zero=".concat(binaryStringDividend));
            }
        }
        System.out.println("final dividend="+binaryStringDividend);
        return  binaryStringDividend;

    }
    public static void main(final String args[]) {
        String data;
        String checksum;
        String syn;
        String dividend;
        String received_data;
        String polynomial="10001000000100001";
        Scanner scanner = new Scanner(System.in);
        System.out.println("main(): Enter the data to be encrypted");

        data = scanner.next();
        System.out.println("main(): data=".concat(data));
        dividend = data;
        int padding=(polynomial.length()-1);
        System.out.println("main(): padding=".concat(String.valueOf(padding)));
        for(int i=0; i<padding;i++){
            dividend+="0";
            System.out.println("main(): dividend=".concat(dividend));
        }

        checksum=crc(dividend,polynomial);
        data=data+checksum;
        System.out.println("main(): Sender checksum=".concat(checksum));
        System.out.println("main(): Codeword transmitted over the network=".concat(data));
        System.out.println("main(): Enter the received codeword");
        received_data=scanner.next();
        syn=crc(received_data,polynomial);

        if(Long.parseLong(syn)==0)
            System.out.println("main(): No error in transmission");
        else
            System.out.println("main(): Error in transmission");
    }
}
