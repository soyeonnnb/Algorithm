import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

// 14:07 ~
public class Main {
    private static int[] parents, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        if (M <= 1) {
            System.out.println("YES");
            return;
        }
        long K=Long.parseLong(st.nextToken());
        arr = new int[N+1];
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Set<Integer> construction = new HashSet<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if ((a == 1 && b == N) || (a == N && b == 1)) construction.add(N);
            else if (a < b) construction.add(a);
            else construction.add(b);
        }
        for(int i=1;i<N;i++) {
            if (construction.contains(i)) continue;
            union(i, i+1);
        }
        if (!construction.contains(N)) union(1, N);
        long sum = 0;
        for(int i=1;i<=N;i++) if (parents[i] == i) sum += arr[i];
        if (sum <= K) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }
    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if(xr == yr) return false;
        if (arr[xr] < arr[yr]) parents[yr] = xr;
        else parents[xr] = yr;
        return true;
    }
}