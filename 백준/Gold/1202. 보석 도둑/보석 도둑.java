import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        int[] bags = new int[K];
        for(int i=0;i<K;i++) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags);

        int idx = 0;
        long ans = 0;
        // 각 가방을 돌면서
        for(int b=0;b<K;b++) {
            while(idx < N && arr[idx][0] <= bags[b]) pq.add(arr[idx++][1]);
            if (!pq.isEmpty())
                ans += pq.poll();
        }
        System.out.println(ans);
    }
}