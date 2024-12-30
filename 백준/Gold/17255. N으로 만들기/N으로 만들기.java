import java.util.HashMap;
import java.util.Map;

public class Main {
    static String N;
    static char[] nums;
    static Map<String, Integer> visited;
    static int answer;

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        N = scanner.next();
        nums = N.toCharArray();
        visited = new HashMap<>();
        answer = 0;

        for (int i = 0; i < nums.length; i++) {
            solution(String.valueOf(nums[i]), i, i, String.valueOf(nums[i]));
        }

        System.out.println(answer);
    }

    public static void solution(String current, int left, int right, String sequence) {
        if (current.equals(N) && !visited.containsKey(sequence)) {
            visited.put(sequence, 0);
            answer++;
            return;
        }

        if (left > 0) {
            solution(nums[left - 1] + current, left - 1, right, sequence + current);
        }
        
        if (right < nums.length - 1) {
            solution(current + nums[right + 1], left, right + 1, sequence + current);
        }
    }
}
