import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 21:53 ~
public class Main {
    private static class Node implements Comparable<Node>{
        int x, y, w;
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] answer = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(answer[i], N*M);
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'S') {
                    pq.add(new Node(i, j, 0));
                    answer[i][j] = 0;
                }
            }
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = N*M;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            for(int k=0;k<4;k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == '#') continue;
                int weight = iswall(now.x, now.y, arr, dx, dy) && iswall(nx, ny, arr, dx, dy) ? now.w : now.w+1;
                if (arr[nx][ny] == 'E') {
                    ans = Math.min(ans, weight);
                } else if (answer[nx][ny] > weight) {
                    pq.add(new Node(nx, ny, weight));
                }
                answer[nx][ny] = Math.min(answer[nx][ny], weight);
            }
        }
        System.out.println(ans);
    }
    private static boolean iswall(int x, int y, char[][] arr, int[] dx, int[] dy) {
        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny=  y + dy[k];
            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
            if (arr[nx][ny] == '#') return true;
        }
        return false;
    }
}