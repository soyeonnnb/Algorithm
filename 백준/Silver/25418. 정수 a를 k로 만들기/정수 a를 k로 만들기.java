
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        boolean[] arr = new boolean[1_000_100];
        arr[A] = true;
        queue.add(A);
        int count = 0;
        outer: while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int now = queue.poll();
                if (now + 1 <= 1000000 && !arr[now+1]) {
                    arr[now+1] = true;
                    queue.add(now+1);
                    if (now + 1 == K) break outer;
                }
                if (now * 2 <= 1000000 && !arr[now * 2]) {
                    arr[now * 2] = true;
                    queue.add(now * 2);
                    if (now * 2 == K) break outer;
                }
            }
            if (arr[K]) break;
        }
        System.out.println(count);

    }
}
