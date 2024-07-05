import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] distance;
    private static boolean[] checked;
    private static int ans, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        count = 0;
        int[][] arr = new int[N][M];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (str.charAt(j)) {
                    case '#':
                        arr[i][j] = -2;
                        break;
                    case 'S':
                        arr[i][j] = 0;
                        list.add(new int[]{i, j, 0});
                        break;
                    case 'X':
                        arr[i][j] = ++count;
                        list.add(new int[]{i, j, count});
                        break;
                    case '.':
                        arr[i][j] = -1;
                        break;
                    case 'E':
                        arr[i][j] = 10;
                        list.add(new int[]{i, j, 10});
                        break;
                }
            }
        }
        distance = new int[11][11];
        boolean[][] visited = new boolean[N][M];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int[] start : list) {
            int idx = start[2];
            Queue<int[]> queue = new LinkedList<>();
            int length = 1;
            queue.add(start);
            for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
            visited[start[0]][start[1]] = true;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int s = 0; s < sz; s++) {
                    int[] now = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == -2 || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        if (arr[nx][ny] != -1) distance[idx][arr[nx][ny]] = length;
                        queue.add(new int[]{nx, ny});
                    }
                }
                length++;
            }
        }
        ans = -1;
        checked = new boolean[count + 1];
        recur(0, 0, 0);
        System.out.println(ans);
    }

    private static void recur(int prev, int cnt, int dist) {
        if (ans != -1 && ans < dist) return;

        if (cnt == count) {
            int res = dist + distance[prev][10];
            ans = ans == -1 ? res : Math.min(ans, res);
            return;
        }

        for (int i = 1; i <= count; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            recur(i, cnt + 1, dist + distance[prev][i]);
            checked[i] = false;
        }
    }
}