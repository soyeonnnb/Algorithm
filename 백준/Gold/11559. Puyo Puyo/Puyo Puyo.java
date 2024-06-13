import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int[][] visited;
    private static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[12][6];
        visited = new int[12][6];
        set = new HashSet<>();
        for(int i=0;i<12;i++) {
            String str = br.readLine();
            for(int j=0;j<6;j++) {
                char c = str.charAt(j);
                if (c == 'R') arr[i][j] = 1;
                else if (c == 'G') arr[i][j] = 2;
                else if (c == 'B') arr[i][j] = 3;
                else if (c == 'P') arr[i][j] = 4;
                else if (c == 'Y') arr[i][j] = 5;
            }
        }
        int ans = 0;
        while(true) {
            if (!check()) break; // 터트릴 게 있는지 확인
            ans++;
            bomb(); // 터트리기
            down(); // 밑으로 내리기
        }

        System.out.println(ans);
    }

    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    private static boolean check() {
        for(int i=0;i<12;i++) Arrays.fill(visited[i], 0);
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<12;i++) {
            for(int j=0;j<6;j++) {
                if (arr[i][j] == 0 || visited[i][j] == 1) continue;
                visited[i][j] = 1;
                queue.clear();;
                queue.add(new int[]{i, j});
                int cnt = 1;
                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for(int k=0;k<4;k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || arr[nx][ny] != arr[i][j] || visited[nx][ny] == 1) continue;
                        cnt++;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                    if (cnt >= 4) return true;
                }
            }
        }
        return false;
    }
    private static void bomb() {
        set.clear();
        for(int i=0;i<12;i++) Arrays.fill(visited[i], 0);
        Queue<int[]> queue = new LinkedList<>();
        int number = 0;
        for(int i=0;i<12;i++) {
            for(int j=0;j<6;j++) {
                if (arr[i][j] == 0 || visited[i][j] != 0) continue;
                number += 10;
                visited[i][j] = number;
                queue.clear();;
                queue.add(new int[]{i, j});
                int cnt = 1;
                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for(int k=0;k<4;k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || arr[nx][ny] != arr[i][j] || visited[nx][ny] != 0) continue;
                        cnt++;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = number;
                    }
                }
                if (cnt >= 4) set.add(number);
            }
        }
    }
    private static void down() {
        for(int j=0;j<6;j++) {
            int idx = 11;
            for(int i=11;i>=0;i--) {
                if (arr[i][j] == 0 || set.contains(visited[i][j])) continue;
                arr[idx--][j] = arr[i][j];
            }
            while(idx >= 0) arr[idx--][j] = 0;
        }
    }
}