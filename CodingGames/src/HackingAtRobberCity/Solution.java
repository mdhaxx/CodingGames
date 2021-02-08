package HackingAtRobberCity;

import java.util.*;

public class Solution {

    Solution(String[] hexStrings) {
        for (String hexString: hexStrings) {
            hexStringToByteArray(hexString);
        }
        decipher(hexStrings);
        byteArraytoString(hexStrings);
    }

    private byte[] hexStringToByteArray(String hexString) {
        byte[] byteArray = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return byteArray;
    }

    private byte[] decipher(String[] hexStrings) {
        byte[] b1 = hexStringToByteArray(hexStrings[0]);
        byte[] b2 = hexStringToByteArray(hexStrings[1]);
        byte[] b3 = hexStringToByteArray(hexStrings[2]);

        byte[] aliceKey = new byte[b2.length];
        for (int i = 0; i < aliceKey.length; i++) {
            aliceKey[i] = (byte) (b2[i] ^ b3[i]);
        }

        byte[] originalMessage = new byte[b1.length];
        for (int i = 0; i < b1.length; i++) {
            originalMessage[i] = (byte) (b1[i] ^ aliceKey[i]);
        }
        return originalMessage;
    }

    private String byteArraytoString(String[] hexStrings) {
        byte[] originalMessage = decipher(hexStrings);
        String encodedString = Base64.getEncoder().encodeToString(originalMessage);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String plainText = new String(decodedBytes);

        System.out.println(plainText);
        return plainText;
    }


    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        //String message1 = in.nextLine();
        //String message2 = in.nextLine();
        //String message3 = in.nextLine();

        String message1 = "391813c092a2d5ac9acb705dfe41be3df08de67d1145cbcc3f";
        String message2 = "03adeae2c8c2f2336c8a8d312733c2456e76e0b2d9068adc3f";
        String message3 = "72d0954e354045f09461dc4c911d0b58ff8963efb12c34303f";
        String[] hexStrings = new String[]{message1, message2, message3};

        new Solution(hexStrings);
    }
}