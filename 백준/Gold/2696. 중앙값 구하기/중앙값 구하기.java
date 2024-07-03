import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> smaller = new PriorityQueue<>((o1, o2) -> o2-o1); // 작은 값은 큰 값부터
        PriorityQueue<Integer> bigger = new PriorityQueue<>(); // 큰 값은 작은값부터
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {

            smaller.clear();
            bigger.clear();

            int M=Integer.parseInt(br.readLine());
            sb.append(M/2+M%2).append("\n");
            st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            sb.append(mid).append(" ");
            for(int i=2;i<=M;i++) {
                if (i%10 == 1) st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if (mid > num) smaller.add(num);
                else bigger.add(num);
                if (i%2 == 1) {
                    if (smaller.size() != bigger.size()) {
                        if (smaller.size() > bigger.size()) {
                            bigger.add(mid);
                            mid = smaller.poll();
                        } else {
                            smaller.add(mid);
                            mid = bigger.poll();
                        }
                    }
                    sb.append(mid).append(" ");
                }
                if (i%20 == 0) sb.append("\n");
            }
            if (M%20 != 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}