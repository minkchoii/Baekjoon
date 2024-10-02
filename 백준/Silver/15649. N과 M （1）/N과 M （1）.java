import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
private static boolean[] visit;
private static int[] arr;
private static StringBuilder result = new StringBuilder();

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokens = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokens.nextToken());
    int M = Integer.parseInt(tokens.nextToken());
    visit = new boolean[N];
    arr = new int[M];

    dfs(N,M,0);
    System.out.println(result);
}

private static void dfs (int N, int M, int depth) {
    //재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
    if (depth == M) {
        for (int val:arr) {
            result.append(val).append(' ');
        }
        result.append('\n');
        return;
    }

    for (int i =0; i< N; i++) {

        //해당 노드를 방문하지 않았다면
        if (!visit[i]) {
            visit[i] = true; //해당 노드를 방문상태로 변경
            arr[depth] = i + 1; //해당 깊이를 index로 하여 i+1값 저장
            dfs(N, M, depth+1); //다음 자식 노드 방문을 위해 depth 1 증가시켜서 재귀호출

            //자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
            visit[i] = false;
        }
    }
}
}