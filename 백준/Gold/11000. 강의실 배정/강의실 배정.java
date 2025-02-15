import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i][0] = start;
            lectures[i][1] = end;
        }

        Arrays.sort(lectures,(a, b)-> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
                });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(lectures[0][1]);

        for(int i=1; i<N; i++) {
            int startTime = lectures[i][0];
            int endTime = lectures[i][1];

            if (!pq.isEmpty() &&pq.peek() <= startTime) {
                pq.poll();
            }
            pq.offer(endTime);

        }
        System.out.println(pq.size());

    }
}
