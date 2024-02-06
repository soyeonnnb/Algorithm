import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr =new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            TreeSet<Integer> set = map.getOrDefault(arr[i][0], new TreeSet<>());
            set.add(arr[i][1]);
            map.put(arr[i][0], set);
        }
        long answer = 0;
        for(int i=0;i<N;i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            TreeSet<Integer> set = map.get(x+A);
            if (set == null) continue;
            if (map.get(x).contains(y+B) && set.contains(y) && set.contains(y+B)) answer++;
        }

        System.out.println(answer);

    }
}