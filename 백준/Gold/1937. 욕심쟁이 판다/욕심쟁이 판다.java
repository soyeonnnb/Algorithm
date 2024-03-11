import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        result = new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(result[i], -1);
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if (result[i][j] == -1) recur(i, j);

            }
        }
        int answer = 0;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) answer = Math.max(answer, result[i][j]);
        System.out.println(answer);
    }

    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    private static void recur(int x, int y) {
        if (result[x][y] != -1) return;
        result[x][y] = 1;

        for(int k=0;k<4;k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[x][y] >= arr[nx][ny]) continue;
            recur(nx, ny);
            result[x][y] = Math.max(result[x][y], result[nx][ny] + 1);
        }
    }
}