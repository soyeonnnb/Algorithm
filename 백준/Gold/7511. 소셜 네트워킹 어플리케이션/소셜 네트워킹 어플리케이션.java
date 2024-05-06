import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15:26 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            sb.append("Scenario ").append(tc).append(":\n");
            int N=Integer.parseInt(br.readLine());
            int K=Integer.parseInt(br.readLine());
            parents = new int[N+1];
            for(int i=0;i<=N;i++) parents[i] = i;
            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            int M=Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (findset(a) == findset(b)) sb.append("1");
                else sb.append("0");
                sb.append("\n");
            }
            sb.append("\n");
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
        parents[yr] = xr;
        return true;
    }
}