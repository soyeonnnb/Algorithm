import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 18:32 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) arr[i][j] = str.charAt(j) == '1';
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        arr[0][0] = false;
        int ans = 1;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        outer: while(!queue.isEmpty()) {
            int sz = queue.size();
            ans++;
            for(int s=0;s<sz;s++) {
                int[] now = queue.poll();
                for(int k=0;k<4;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || !arr[nx][ny]) continue;
                    queue.add(new int[]{nx, ny});
                    arr[nx][ny] = false;
                    if (nx == N-1 && ny == M-1) break outer;
                }
            }
        }
        System.out.println(ans);
    }
}