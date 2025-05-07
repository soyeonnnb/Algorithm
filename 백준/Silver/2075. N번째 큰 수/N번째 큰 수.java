
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int input = Integer.parseInt(st.nextToken());
                if (pq.size() >= N) {
                    if (pq.peek() > input) continue;
                    else  {
                        pq.poll();
                        pq.add(input);
                    }
                } else {
                    pq.add(input);
                }
            }
        }
        System.out.println(pq.peek());
    }
}
