import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> xset = new TreeSet<>();
        Set<Integer> yset = new TreeSet<>();
        for(int i=0;i<N;i++) {
            xset.add(arr[i][0]);
            yset.add(arr[i][1]);
        }
        StringBuilder sb = new StringBuilder();
        int[] result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Integer x : xset) {
            for(Integer y : yset) {
                queue.clear();
                for(int i=0;i<N;i++) queue.add(Math.abs(x - arr[i][0]) + Math.abs(y - arr[i][1]));
                int temp = 0;
                for(int i=1;i<=N;i++) {
                    temp += queue.poll();
                    result[i] = Math.min(result[i], temp);
                }
            }
        }
        for(int n=1;n<=N;n++) { // n개가 모이는 것
            sb.append(result[n]+" ");
        }
        System.out.println(sb);

    }
}