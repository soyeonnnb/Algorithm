import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 14:25 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> minq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        PriorityQueue<int[]> maxq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        for(int i=0;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = (Integer.parseInt(st.nextToken()) + 1)%2;
            minq.add(arr);
            maxq.add(arr);
        }
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        int min = poll(minq, N);
        for(int i=0;i<=N;i++) parents[i] = i;
        int max = poll(maxq, N);
        System.out.println(max*max - min*min);
    }

    private static int poll(PriorityQueue<int[]> pq, int N) {
        int ans = 0;
        int connected = 0;

        while(!pq.isEmpty() && connected != N) {
            int[] now = pq.poll();
            if (union(now[0], now[1])) {
                ans += now[2];
                connected++;
            }
        }
        return ans;
    }


    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;
        parents[yr] = xr;
        return true;
    }
}