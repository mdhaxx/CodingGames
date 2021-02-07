package DecodeTheMessage;

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    Solution(String c, long p) {
        key(c);
        message(c, p);
    }

    private long powerN(int number, int power) {
        return (long) Math.pow(number, power);
    }

    private String[] key(String c) {
        char[] alphabet = c.toCharArray();
        int len = alphabet.length;
        String[] keyArray = new String[(int) powerN(26,4)];

        for(int i = 0; i < (len * 4); i++) {
            if(i < 26) {
                keyArray[i] = String.valueOf(alphabet[i]);
            } else if(i < 52) {
                keyArray[i] = String.valueOf(alphabet[i - 26]) + keyArray[0];
            } else if(i < 77 ) {
                keyArray[i] = String.valueOf(alphabet[i - (2*26)]) + keyArray[1];
            }
        }
        return keyArray;
    }

    private void message(String c, long p) {
        String[] keyArray = key(c);
        String message = keyArray[(int)p];
        System.out.println(message);

    }

    public static void main(String[] args) {
        String c = "abcdefghijklmnopqrstuvwxyz";
        long p = 35;
        new Solution(c,p);

        /*
        Scanner in = new Scanner(System.in);
        long P = in.nextLong();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String C = in.nextLine();

        System.out.println("Good Luck :->");

        long P = 35;
        String C = "abcdefghijklmnopqrstuvwxyz";
        String output = "ja";
    */
    }
}