import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        for (int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i][0] = start;
            meetings[i][1] = end;
        }
        Arrays.sort(meetings,(a,b)-> {
            if ( a[1]==b[1]) return a[0]-b[0];
           return a[1] - b[1]; });

        int cnt = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            if ( startTime >= lastEndTime) {
                cnt++;
                lastEndTime = endTime;
            }
        }
        System.out.println(cnt);
        }
    }

