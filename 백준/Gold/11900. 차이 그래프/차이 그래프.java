import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 21:07 ~
// 질문 게시판 읽고 품
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dij = new int[N];
        Arrays.fill(dij, -1);
        dij[0] = 0;
        boolean[] visited = new boolean[N];
        for(int s=0;s<N;s++) {
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                if (!visited[i] && dij[i] != -1 && dij[i] < min) {
                    idx = i;
                    min = dij[i];
                }
            }
            visited[idx] = true;
            for(int i=0;i<N;i++) {
                if (i == idx || visited[i]) continue;
                int target = idx - i;
                if (idx < i) target = idx - i + N;
                if (arr[target] == 0) continue;
                if (dij[i] == -1 || dij[i] > min + arr[target]) {
                    dij[i] = min + arr[target];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int Q=Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int idx = b-a;
            if (idx < 0) idx+=N;
            sb.append(dij[idx]+"\n");
        }
        System.out.println(sb);
    }
}