import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> weightMap = new HashMap<>();
        for (String word : words) {
            int power = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + power);
                power *= 10;
            }
        }

        List<Character> sortedKeys = new ArrayList<>(weightMap.keySet());
        sortedKeys.sort((a, b) -> weightMap.get(b) - weightMap.get(a));

        Map<Character, Integer> charToNumber = new HashMap<>();
        int number = 9;
        for (char ch : sortedKeys) {
            charToNumber.put(ch, number--);
        }

        int totalSum = 0;
        for (String word : words) {
            int num = 0;
            for (char ch : word.toCharArray()) {
                num = num * 10 + charToNumber.get(ch);
            }
            totalSum += num;
        }

        System.out.println(totalSum);
    }
}
