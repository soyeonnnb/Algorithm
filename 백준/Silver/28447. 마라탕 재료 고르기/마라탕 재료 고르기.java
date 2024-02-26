import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, answer;
    private static int[][] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = -987654321;
        visited = new boolean[N];
        recur(0, 0);
        System.out.println(answer);
    }
    private static void recur(int cur, int checked) {
        if (checked == K) {
            int temp = 0;
            for(int i=0;i<N;i++) {
                if (!visited[i]) continue;
                for(int j=0;j<N;j++) if (visited[j]) temp += arr[i][j];
            }
            answer = Math.max(answer, temp/2);
            return;
        }
        if (cur == N) {
            return;
        }

        visited[cur] = true;
        recur(cur+1, checked + 1);
        visited[cur] = false;
        recur(cur+1, checked);
    }
}