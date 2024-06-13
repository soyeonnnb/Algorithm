import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq= new PriorityQueue<>((o1, o2) -> o1[2] == o2[2] ? o1[0] - o2[0] : o2[2] - o1[2]);
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++) {
            if (pq.isEmpty()) break;
            int[] now = pq.poll();
            sb.append(now[0]).append("\n");
            if (now[1] == 1) continue;
            now[1]--;
            now[2]--;
            pq.add(now);
        }
        System.out.println(sb);
    }
}