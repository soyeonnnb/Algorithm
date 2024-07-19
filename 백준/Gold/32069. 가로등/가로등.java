import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long L=Long.parseLong(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Set<Long> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for(int i=0;i<N;i++) {
            long nxt = Long.parseLong(st.nextToken());
            set.add(nxt);
            queue.add(nxt);
            sb.append("0\n");
            cnt++;
            if (cnt == K) {
                System.out.println(sb);
                return;
            }
        }

        int now = 0;
        int[] dx = new int[]{-1, 1};
        outer: while(!queue.isEmpty()) {
            int sz = queue.size();
            now ++;
            for(int s=0;s<sz;s++) {
                long x = queue.poll();
                for(int k=0;k<2;k++) {
                    long nxt = x + dx[k];
                    if (nxt < 0 || nxt > L || set.contains(nxt)) continue;
                    cnt++;
                    sb.append(now).append("\n");
                    set.add(nxt);
                    queue.add(nxt);
                    if (cnt == K) break outer;
                }
            }
        }
        System.out.println(sb);
    }
}