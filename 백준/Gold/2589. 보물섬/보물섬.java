import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 19:44 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][];
        for(int i=0;i<N;i++) arr[i] = br.readLine().toCharArray();
        boolean[][] visited = new boolean[N][M];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (arr[i][j] == 'W') continue;
                for(int k=0;k<N;k++) Arrays.fill(visited[k], false);
                queue.clear();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                int result = -1;
                while(!queue.isEmpty()) {
                    int sz = queue.size();
                    result++;
                    for(int s=0;s<sz;s++) {
                        int[] now = queue.poll();
                        for(int k=0;k<4;k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 'W') continue;
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                ans = Math.max(ans, result);
            }
        }
        System.out.println(ans);
    }
}