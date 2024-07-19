import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node>{
        int x, potion;
        double weight;

        protected Node(int x, int potion, double weight) {
            this.x = x;
            this.potion = potion;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight != o.weight) return Double.compare(this.weight, o.weight);
            else if (this.potion != o.potion) return this.potion - o.potion;
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", potion=" + potion +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        double[][] dp = new double[N][K+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        // 도시번호, 가는데 걸리는 시간, 사용 횟수
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0.0));
        dp[0][0] = 0;
        double ans = -1;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (ans != -1 && ans < now.weight) break;
            if (dp[now.x][now.potion] != now.weight) continue;

            if (now.x == 1) {
                ans = now.weight;
                break;
            }

            for(int i=0;i<N;i++) {
                if (i == now.x) continue;
                double nxt = now.weight + arr[now.x][i];
                if (dp[i][now.potion] != -1 && dp[i][now.potion] <= nxt) continue;

                dp[i][now.potion] = nxt;
                pq.add(new Node(i, now.potion, nxt));

                if (now.potion < K) {
                    nxt = now.weight + arr[now.x][i] / 2.0;
                    if (dp[i][now.potion + 1] != -1 && dp[i][now.potion + 1] <= nxt) continue;

                    dp[i][now.potion + 1] = nxt;
                    pq.add(new Node(i,now.potion + 1, nxt));
                }
            }

            if (now.potion == K) continue;

            for(int i=0;i<N;i++) {
                double nxt = now.weight + arr[now.x][i] / 2.0;
                if (dp[i][now.potion + 1] != -1 && dp[i][now.potion + 1] <= nxt) continue;
                dp[i][now.potion + 1] = nxt;
                pq.add(new Node(i,now.potion + 1, nxt));
            }
        }
        System.out.println(ans);
    }
}