import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 22:00 ~
// DFS로 풀어보자 !
public class Main {
    private static int N, M, answer;
    private static int[][] arr; 
    private static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++) {
            String str =br.readLine();
            for(int j=0;j<M;j++) arr[i][j] = str.charAt(j) - 'A';
        }
        alpha = new boolean[26];
        alpha[arr[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static void dfs(int x, int y, int count) {
        answer = Math.max(answer, count);
        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || alpha[arr[nx][ny]]) continue;
            alpha[arr[nx][ny]] = true;
            dfs(nx, ny, count+1);
            alpha[arr[nx][ny]] = false;
        }
    }
}