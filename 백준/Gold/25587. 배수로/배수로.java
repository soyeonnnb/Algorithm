import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13:12 ~
public class Main {
    private static int[] parents, rain, volume, child;
    private static int flood;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        child = new int[N+1];
        Arrays.fill(child, 1);
        for(int i=0;i<=N;i++) parents[i] = i;
        volume = new int[N+1]; // 배수로 용량
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) volume[i] = Integer.parseInt(st.nextToken());
        rain = new int[N+1]; // 강수량

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) rain[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        flood = 0;
        for(int i=1;i<=N;i++) {
            if (volume[i] < rain[i]) flood++;
        }
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 2) {
                sb.append(flood).append("\n");
                continue;
            }

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);

        }
        System.out.println(sb);
    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;

        // 항상 xr에 yr이 붙도록
        if (volume[xr] < rain[xr]) flood -= child[xr];
        if (volume[yr] < rain[yr]) flood -= child[yr];

        rain[xr] += rain[yr];
        volume[xr] += volume[yr];
        child[xr] += child[yr];
        if (volume[xr] < rain[xr]) flood += child[xr];

        parents[yr] = xr;
        return true;
    }
}

