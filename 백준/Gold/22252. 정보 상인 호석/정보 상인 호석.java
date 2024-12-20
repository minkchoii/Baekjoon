import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bf.readLine()); //첫 줄에 쿼리 개수 주어짐

        // map을 이용해 그룹별데이터 관리.
        // key는 그룹이름, 값은 그룹 내 정보들의 우선순위 큐
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        //result에 각 쿼리에서 얻은 최대값들 합 저장
        long result = 0;

        for (int i = 0; i < q; i++) {
            String query = bf.readLine();
            StringTokenizer st = new StringTokenizer(query);

            int code = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            // 1이면 정보 추가
            if (code == 1) {
                for (int j = 0; j < count; j++) {
                    //그룹이 map에 존재하지 않는 경우
                    if (!map.containsKey(name)) {
                        //우선순위큐를 생성해 Collections.reverseOrder()로 최대 힙 설정
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        //첫 번째 정보 추가하고 map에 저장
                        pq.add(Integer.parseInt(st.nextToken()));
                        map.put(name, pq);
                    } //이미 존재하는 경우 우선순위큐에 새로운 정보만 추가해줌
                     else {
                        map.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            // 2면 최대값 추출해서 합산해줌
             else {
                 //그룹이 존재하지않으면 건너뜀
                if (map.get(name) == null) continue;
                while (!map.get(name).isEmpty() && count > 0) {
                    //poll()로 큐에서 우선순위가 높은 데이터를 반환함과 동시에 삭제
                    result += map.get(name).poll();
                    count--;
                }
            }
        }
        System.out.println(result);
    }
}