import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, ans;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        recur(0, 0);
        System.out.println(ans);
    }
    private static void recur(int idx, int sum) {
        if (idx == N-2) {
            ans = Math.max(ans, sum);
            return;
        }
        int s = 1;
        int e = N-2;
        while(visited[s])s++;
        while(visited[e])e--;
        for(int i=s;i<=e;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int nx = i;
            int ny = i;
            while(visited[nx]) nx--;
            while(visited[ny]) ny++;
            recur(idx+1, sum + arr[nx] * arr[ny]);
            visited[i] = false;
        }

    }
}
