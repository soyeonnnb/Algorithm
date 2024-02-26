import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answerG, answerS, N, M;
    private static boolean[][] arr;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String str = st.nextToken();
            for(int j=0;j<M;j++) if (str.charAt(j) == 'Y') arr[i][j] = true;
        }
        visited = new int[M];
        answerG = -1;
        answerS = 0;
        recur(0, 0, 0);
        System.out.println(answerG);
    }
    private static void recur(int cur, int guiters, int songs) {
        if (answerS < songs) {
            answerS = songs;
            answerG = guiters;
        } else if (songs > 0 && answerS == songs) answerG = Math.min(answerG, guiters);
        if (cur == N) return;
        if (songs == M) {
            return;
        }
        recur(cur+1, guiters, songs);
        int temp = 0;
        for(int i=0;i<M;i++) {
            if (arr[cur][i]) {
                if (visited[i] == 0) temp++;
                visited[i]++;
            }
        }
        recur(cur+1, guiters+1, songs+temp);
        for(int i=0;i<M;i++) {
            if (arr[cur][i]) {
                visited[i]--;
            }
        }
    }
}