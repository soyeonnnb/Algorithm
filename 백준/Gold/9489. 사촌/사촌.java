import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1001];
        int[] parent = new int[1001];
        List<Integer>[] list = new List[1001];

        for(int i=0;i<=1000;i++) list[i] = new ArrayList<>();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            if (N == 0 && K == 0) break;
            st = new StringTokenizer(br.readLine());
            Arrays.fill(arr, 0);
            Arrays.fill(parent, 0);
            parent[0] = -1;
            for(int i=0;i<=N;i++) list[i].clear();

            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++) {
                if (arr[i] == K) {
                    K = i;
                    break;
                }
            }
            int now = -1;
            for(int i=1;i<N;i++) {
                if (arr[i] != arr[i-1] + 1) {
                    now++;
                }
                parent[i] = now;
                list[now].add(i);
            }
            if(parent[K] == -1) {
                sb.append("0\n");
                continue;
            }
            int p_parent = parent[parent[K]];
            if (p_parent == -1) {
                sb.append("0\n");
                continue;
            }
            List<Integer> li = list[p_parent];
            int count = 0;
            for(int p : li) {
                if (p == parent[K]) continue;
                count += list[p].size();
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}