import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) arr[i][j] = str.charAt(j) - '0' == 0;
        }

        int[][][] walls = new int[N][M][2]; //  해당 지점까지 현재 부순 횟수 + 낮밤
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) Arrays.fill(walls[i][j], K+2); // 총 몇번 부수었는지
        int[][][] dp = new int[N][M][2]; // i, j + 낮/밤
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) Arrays.fill(dp[i][j], -1);
        dp[0][0][0] = 1;
        walls[0][0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0, 1}); // x, y, k, 낮/밤, count
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == N-1 && now[1] == M-1) {
                System.out.println(now[4]);
                return;
            }
            int nextDay = (now[3] + 1) % 2; // 다음날
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 만약 가려는 곳이 이동할 수 있는 곳이면
                if (arr[nx][ny]) {
                    if (dp[nx][ny][nextDay] != -1 && walls[nx][ny][nextDay] <= now[2]) continue;
                    dp[nx][ny][nextDay] = now[4] + 1;
                    walls[nx][ny][nextDay] = now[2];
                    queue.add(new int[]{nx, ny, now[2], nextDay, now[4] + 1});
                } else { // 만약에 벽이면
                    if (now[3] == 1 || now[2] == K) continue; // 밤에는 벽을 부술 수 없음 + 최대 K번 부술 수 있음
                    if (dp[nx][ny][nextDay] != -1 && walls[nx][ny][nextDay] <= now[2]) continue; // 이미 간 곳이면 못감 / 이미 그 곳까지 더 적은 수로 부수었으면 안감
                    dp[nx][ny][nextDay] = now[4] + 1;
                    walls[nx][ny][nextDay] = now[2];
                    queue.add(new int[]{nx, ny, now[2]+1, nextDay, now[4] + 1});
                }
            }
            // 같은 자리 머무르기
            if (dp[now[0]][now[1]][nextDay] != -1 && walls[now[0]][now[1]][nextDay] <= now[2]) continue;
            dp[now[0]][now[1]][nextDay] = now[4] + 1;
            walls[now[0]][now[1]][nextDay] = now[2];
            queue.add(new int[]{now[0], now[1], now[2], nextDay, now[4]+1});
        }
        System.out.println(-1);

    }
}