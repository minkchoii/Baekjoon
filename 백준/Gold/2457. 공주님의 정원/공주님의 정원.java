import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers[i] = new Flower(start, end);
        }
        
        Arrays.sort(flowers, (f1, f2) -> {
            if (f1.start == f2.start) return f2.end - f1.end;
            return f1.start - f2.start;
        });
        
        int currentEnd = 301;
        int nextEnd = 0; 
        int index = 0, count = 0; 

        while (currentEnd < 1201) { 
            boolean found = false;
            
            while (index < N && flowers[index].start <= currentEnd) {
                nextEnd = Math.max(nextEnd, flowers[index].end);
                index++;
                found = true;
            }

            if (!found) break;

            count++;
            currentEnd = nextEnd;

            if (currentEnd >= 1201) { 
                System.out.println(count);
                return;
            }
        }
        
        System.out.println(0);
    }

    static class Flower {
        int start, end;
        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
