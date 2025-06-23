
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        int count = 0;
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (!arr[i][j]) continue;
                count++;
                queue.add(new int[] {i, j});
                arr[i][j] = false;
                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int k = 0; k < 8; k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || !arr[nx][ny]) continue;
                        arr[nx][ny] = false;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        System.out.println(count);
    }
}
