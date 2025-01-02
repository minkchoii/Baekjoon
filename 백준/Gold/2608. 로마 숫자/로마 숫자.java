import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String roman1 = br.readLine();
        String roman2 = br.readLine();

        int num1 = romanToNumber(roman1);
        int num2 = romanToNumber(roman2);
        int sum = num1 + num2;

        String romanSum = numberToRoman(sum);

        bw.write(sum + "\n" + romanSum);
        bw.flush();
        bw.close();
    }

    private static int romanToNumber(String roman) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int sum = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanValues.get(roman.charAt(i));
            if (value < prevValue) {
                sum -= value;
            } else {
                sum += value;
            }
            prevValue = value;
        }

        return sum;
    }

    private static String numberToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
