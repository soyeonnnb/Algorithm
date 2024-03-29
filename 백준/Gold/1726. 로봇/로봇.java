import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12:53 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken()) == 0;
        }
        int[][][] arr = new int[N][M][4];
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) Arrays.fill(arr[i][j], -1);
        Queue<int[]> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int[] finish = new int[3];
        finish[0] = Integer.parseInt(st.nextToken()) -1;
        finish[1] = Integer.parseInt(st.nextToken()) -1;
        finish[2] = convertToDir(Integer.parseInt(st.nextToken()));
        arr[finish[0]][finish[1]][finish[2]] = 0;
        queue.add(new int[]{finish[0], finish[1], finish[2], 0});
        st = new StringTokenizer(br.readLine());
        finish[0] = Integer.parseInt(st.nextToken()) -1;
        finish[1] = Integer.parseInt(st.nextToken()) -1;
        finish[2] = convertToDir(Integer.parseInt(st.nextToken()));
        int[] dx = new int[]{-1, 0, 1, 0}; // 북 서 남 동
        int[] dy = new int[]{0, -1, 0, 1};
        outer: while(!queue.isEmpty()) {
            int[] now = queue.poll();
//            System.out.println(Arrays.toString(now));
            // 직진
            for(int k=1;k<=3;k++) {
                int nx = now[0] + dx[now[2]] * k;
                int ny = now[1] + dy[now[2]] * k;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!map[nx][ny]) break;
                if (arr[nx][ny][now[2]] != -1) continue; // 이미 이전에 옴 == 더 짧은 시간임
                arr[nx][ny][now[2]] = now[3] + 1;
                if (nx == finish[0] && ny == finish[1] && now[2] == finish[2]) break outer;
                queue.add(new int[]{nx, ny, now[2], now[3] + 1});
            }
            // 방향 돌기
            int dir = now[2] + 1;
            if (dir == 4) dir = 0;
            if (arr[now[0]][now[1]][dir] == -1) {
                arr[now[0]][now[1]][dir] = now[3] + 1;
                queue.add(new int[]{now[0], now[1], dir, now[3] + 1});
            }
            dir = now[2] - 1;
            if (dir < 0) dir = 3;
            if (arr[now[0]][now[1]][dir] == -1) {
                arr[now[0]][now[1]][dir] = now[3] + 1;
                queue.add(new int[]{now[0], now[1], dir, now[3] + 1});
            }
        }
        System.out.println(arr[finish[0]][finish[1]][finish[2]]);
    }
    private static int convertToDir(int x) {
        if (x == 1) return 3;
        else if (x == 2) return 1;
        else if (x == 3) return 2;
        else return 0;
    }
}