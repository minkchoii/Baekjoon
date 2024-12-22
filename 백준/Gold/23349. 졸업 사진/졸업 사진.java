import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, TreeMap<Integer, Integer>> placeMap = new HashMap<>();
        Set<String> submittedNames = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            if (submittedNames.contains(name)) continue;
            submittedNames.add(name);

            if (!placeMap.containsKey(place)) {
                placeMap.put(place, new TreeMap<>());
            }

            TreeMap<Integer, Integer> timeMap = placeMap.get(place);
            for (int time = start; time < end; time++) {
                if (!timeMap.containsKey(time)) {
                    timeMap.put(time, 1);
                } else {
                    timeMap.put(time, timeMap.get(time) + 1);
                }
            }
        }

        String bestPlace = null;
        int maxVisitors = 0;
        int bestStart = 0;

        for (String place : placeMap.keySet()) {
            TreeMap<Integer, Integer> timeMap = placeMap.get(place);
            for (int time : timeMap.keySet()) {
                int visitors = timeMap.get(time);

                if (visitors > maxVisitors ||
                        (visitors == maxVisitors && (bestPlace == null || place.compareTo(bestPlace) < 0)) ||
                        (visitors == maxVisitors && place.equals(bestPlace) && time < bestStart)) {
                    bestPlace = place;
                    maxVisitors = visitors;
                    bestStart = time;
                }
            }
        }

        int bestEnd = bestStart;
        TreeMap<Integer, Integer> timeMap = placeMap.get(bestPlace);
        while (timeMap.containsKey(bestEnd) && timeMap.get(bestEnd) == maxVisitors) {
            bestEnd++;
        }

        bw.write(bestPlace + " " + bestStart + " " + bestEnd);
        bw.flush();
        bw.close();
    }
}
