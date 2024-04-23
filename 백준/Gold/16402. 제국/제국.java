import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 13:08 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        Map<String, Integer> map = new TreeMap<>();
        String[] names = new String[N+1];
        String[] strs;
        for(int i=1;i<=N;i++) {
            strs = br.readLine().split(" ");
            map.put(strs[2], i);
            names[i] = strs[2];
        }
        for(int m=0;m<M;m++) {
            strs = br.readLine().split(",");
            int k1 = map.get(strs[0].split(" ")[2]);
            int k2 = map.get(strs[1].split(" ")[2]);
            int result = strs[2].charAt(0) - '0';
            if (result == 1) union(k1, k2);
            else union(k2, k1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++) {
            if (parents[i] == i) pq.add(names[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            sb.append("Kingdom of ").append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }

    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }

    private static void union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);

        // 같은 왕국일 경우에
        if(xr == yr) {
            parents[x] = x;
            parents[y] = x;
            return ;
        }
        // 다른 왕국일 경우에
        parents[yr] = xr;
    }
}