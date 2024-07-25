import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i] = i;

        int[][] dij = new int[N+1][N+1];
        for(int i=0;i<=N;i++) Arrays.fill(dij[i], -1);
        for(int i=0;i<=N;i++) dij[i][i] = 0;

        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dij[a][b] = 1;
            dij[b][a] = 1;
            union(a, b);
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                if (dij[i][k] == -1) continue;
                for(int j=1;j<=N;j++) {
                    if (dij[k][j] == -1 || findset(i) != findset(j)) continue;
                    int sum = dij[i][k] + dij[k][j];
                    dij[i][j] = dij[i][j] == -1 ? sum : Math.min(dij[i][j], sum);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int min = i;
            int person = 0;
            for(int k=1;k<=N;k++) person = Math.max(person, dij[i][k]);
            for(int j=i;j<=N;j++) {
                if (findset(i) != findset(j)) continue;
                visited[j] = true;
                int max = 0;
                for(int k=1;k<=N;k++) max = Math.max(max, dij[j][k]);
                if (person > max) {
                    min = j;
                    person = max;
                }
            }
            ans.add(min);
        }
        ans.sort(Comparator.naturalOrder());
        System.out.println(ans.size());
        for(int a : ans) System.out.println(a);
    }

    private static int findset(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);

        if (xr == yr) return false;
        if (xr < yr) parent[yr] = xr;
        else parent[xr] = yr;
        return true;
    }
}