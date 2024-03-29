import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20:12 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) queue.add(new int[]{i, j});
                else if (arr[i][j] == 0) count++;
            }
        }
        int ans = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while(count > 0 && !queue.isEmpty()) {
            int sz = queue.size();
            ans++;
            for(int s=0;s<sz;s++) {
                int[] now = queue.poll();
                for(int k=0;k<4;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] != 0) continue;
                    arr[nx][ny] = 1;
                    count--;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(count>0 ? -1 : ans);
    }
}