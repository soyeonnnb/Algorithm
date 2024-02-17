import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, answer;
    private static int[] A;
    private static int[][] R, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
        R = new int[K][N];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) R[i][j] = Integer.parseInt(st.nextToken());
        }
        M = new int[K][N];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) M[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        recur(0, 0, false);
        System.out.println(answer);
    }
    private static void recur(int cur, int sum, boolean isR) {
        if (cur ==K) {
            if (isR) {
                answer = Math.max(answer, sum);
            } else {
                recur(0, sum, true);
            }
            return;
        }
        for(int i=0;i<N;i++) {
            if (A[i] == 0) continue;
            A[i]--;
            recur(cur+1, isR?sum+R[cur][i]:sum+M[cur][i], isR);
            A[i]++;
        }
    }
}