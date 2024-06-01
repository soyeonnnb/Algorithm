import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer>[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new PriorityQueue[5][5];
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) list[i][j] = new PriorityQueue<>((o1, o2) -> o2-o1);
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            int start = map.get(str.charAt(0));
            int end = map.get(str.charAt(str.length()-1));
            list[start][end].add(str.length());
        }
        // 각 단어로 시작하는 기준으로 시작
        int ans = 0;
        for(int i=0;i<5;i++) ans = Math.max(ans, recur(i, 0));
        System.out.println(ans);

    }
    private static int recur(int start, int length) {

        int result = length;

        // 해당 단어로 시작하는 단어 확인
        for(int i=0;i<5;i++) {
            if (list[start][i].isEmpty()) continue; // 더 못가면 그냥 패스
            int now = list[start][i].poll();
            result = Math.max(result, recur(i, length + now));
            list[start][i].add(now); // 다시 집어넣기
        }

        return result;
    }
}