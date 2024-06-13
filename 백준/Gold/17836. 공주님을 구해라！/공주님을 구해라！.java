import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[N][M][2];
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) Arrays.fill(dp[i][j], -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // x, y, 소드 있으면:1, 없으면:0
        dp[0][0][0] = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for(int t=1;t<=T;t++) {
            int sz = queue.size();
            for(int s=0;s<sz;s++) {
                int[] now = queue.poll();
                for(int k=0;k<4;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || dp[nx][ny][now[2]] != -1) continue;
                    if (arr[nx][ny] == 1 && now[2] == 0) continue; // 소드 없는데 벽이면 못감
                    else if (arr[nx][ny] == 2) { // 만약 소드가 있는 곳이면
                        dp[nx][ny][0] = t;
                        dp[nx][ny][1] = t;
                        queue.add(new int[]{nx, ny, 1});
                    } else {
                        dp[nx][ny][now[2]] = t;
                        queue.add(new int[]{nx, ny, now[2]});
                    }
                }
            }
        }
        if (dp[N-1][M-1][0] == -1 && dp[N-1][M-1][1] == -1) System.out.println("Fail");
        else if (dp[N-1][M-1][0] != -1 && dp[N-1][M-1][1] != -1) System.out.println(Math.min(dp[N-1][M-1][0], dp[N-1][M-1][1]));
        else System.out.println(Math.max(dp[N-1][M-1][0], dp[N-1][M-1][1]));
    }
}