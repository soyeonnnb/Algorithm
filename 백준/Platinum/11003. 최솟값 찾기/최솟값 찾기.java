import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int index=1;index<=N;index++) {
            int num = Integer.parseInt(st.nextToken());
            int left = index - L + 1 < 1 ? 1 : index - L + 1;

            // 일단 날짜 지난거 빼기
            while(!dq.isEmpty() && dq.peekFirst()[1] < left) {
                dq.pollFirst();
            }

            if (dq.isEmpty() || dq.getFirst()[0] >= num) {
                dq.clear();
                dq.addLast(new int[]{num, index});
                sb.append(dq.peekFirst()[0]).append(" ");
                continue;
            }

            while(!dq.isEmpty() && dq.peekLast()[0] >= num) {
                dq.pollLast();
            }

            dq.addLast(new int[]{num, index});
            sb.append(dq.peek()[0]).append(" ");
        }
        System.out.println(sb);
    }
}