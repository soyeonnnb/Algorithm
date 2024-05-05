import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        int x, y, time;
        long moved;
        Node(int x, int y, int time, long moved) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.moved = moved;
        }

        @Override
        public int compareTo(Node o) {
            return this.moved < o.moved ? -1 : 1;
        }

        @Override
        public String toString() {
            return "[Node x="+x+", y="+y+", time="+time+", moved="+moved+"]";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[][][] visited = new boolean[N][N][3];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0, 0L));
        long ans = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.x][now.y][now.time]) continue;
            if (now.x == N-1 && now.y == N-1) {
                ans = now.moved;
                break;
            }
            visited[now.x][now.y][now.time] = true;
            int nt = now.time + 1;
            if (nt == 3) nt = 0;
            long nm = now.moved + T;
            for(int k=0;k<4;k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny][nt]) continue;
                pq.add(new Node(nx, ny, nt, nt == 0 ? nm + arr[nx][ny] : nm));
            }
        }

        System.out.println(ans);

    }

}