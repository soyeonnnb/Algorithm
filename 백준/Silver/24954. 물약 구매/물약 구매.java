import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static boolean[] visited;
    private static int[] cost, prices;
    private static ArrayList<int[]>[] sales;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        answer = 987654321;
        cost = new int[N+1];
        visited = new boolean[N+1];
        prices = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) cost[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) prices[i] = cost[i];
        sales = new ArrayList[N+1];
        for(int i=1;i<=N;i++) sales[i] = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                sales[i].add(new int[]{num, p});
            }
        }
        recur(1, 0);
        System.out.println(answer);
    }
    private static void recur(int cur, int result) {
        if (result > answer) return;
        if (cur == N+1) {
            answer = Math.min(answer, result);
            return;
        }
        for(int i=1;i<=N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            for(int[] arr : sales[i]) {
                prices[arr[0]] -= arr[1];
            }
            recur(cur+1, result + (Math.max(prices[i], 1)));
            visited[i] = false;
            for(int[] arr : sales[i]) {
                prices[arr[0]] += arr[1];
            }
        }
    }

}