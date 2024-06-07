import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o2[2]-o1[2]);
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if (i != 1 && i != N && j != 1 && j != M) continue;
                pq.add(new int[]{i, j, arr[i][j]});
                arr[i][j] = -1;
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int[] now = pq.poll();
            sb.append(now[0]).append(" ").append(now[1]).append("\n");
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 1 || nx > N || ny < 1 || ny > M || arr[nx][ny] == -1) continue;
                pq.add(new int[]{nx, ny, arr[nx][ny]});
                arr[nx][ny] = -1;
            }
        }
        System.out.println(sb);

    }
}