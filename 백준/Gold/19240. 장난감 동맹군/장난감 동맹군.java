import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 13:38 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] group = new int[300010];
        test: for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            List<Integer>[] list = new List[N+1];
            Arrays.fill(group, -1);
            for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i=1;i<=N;i++) {
                if (group[i] != -1) continue;
                queue.clear();
                queue.add(i);
                group[i] = 0;
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    for(int x : list[now]) {
                        if (group[x] == -1) {
                            group[x] = (group[now] + 1) % 2;
                            queue.add(x);
                        } else if (group[x] == group[now]) {
                            sb.append("NO\n");
                            continue test;
                        }
                    }
                }
            }
            sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
