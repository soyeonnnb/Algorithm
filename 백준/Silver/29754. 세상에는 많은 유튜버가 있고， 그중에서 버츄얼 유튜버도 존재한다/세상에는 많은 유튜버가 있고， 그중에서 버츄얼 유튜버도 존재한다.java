import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Map<String, int[]> timeMap = new HashMap<>();
        Map<String, int[]> countMap = new HashMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String[] startString = st.nextToken().split(":");
            Integer start = getTime(Integer.parseInt(startString[0]), Integer.parseInt(startString[1]));
            String[] endString = st.nextToken().split(":");
            Integer end = getTime(Integer.parseInt(endString[0]), Integer.parseInt(endString[1]));
            int[] time = timeMap.getOrDefault(name, new int[(M+1)/7+1]);
            time[(day-1)/7] += end - start;
            timeMap.put(name, time);
            int[] count = countMap.getOrDefault(name, new int[(M+1)/7+1]);
            count[(day-1)/7]++;
            countMap.put(name, count);
        }
        List<String> ans = new ArrayList<>();
        for(String name : timeMap.keySet()) {
            if (checkTime(timeMap.get(name),M) && checkCount(countMap.get(name), M)) ans.add(name);
        }
        ans.sort(String::compareTo);
        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for(String name : ans) {
                System.out.println(name);
            }
        }
    }
    private static Integer getTime(int hour, int minute) {
        return hour * 60 + minute;
    }
    private static boolean checkTime(int[] time, int M) {
        for(int i=0;i<M/7;i++) {
            if (time[i] < 3600) return false;
        }
        return true;
    }
    private static boolean checkCount(int[] count, int M) {
        for(int i=0;i<M/7;i++) {
            if (count[i] < 5) return false;
        }
        return true;
    }
}
