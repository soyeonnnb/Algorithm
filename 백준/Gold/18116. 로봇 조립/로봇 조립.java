import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12:06 ~
public class Main {
    private static int[] parent;
    private static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parent = new int[1000010];
        size = new int[1000010];
        for(int i=0;i<=1000000;i++) parent[i] = i;
        Arrays.fill(size, 1);
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int q=0;q<N;q++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            switch (ch) {
                case 'I':
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    union(a, b);
                    break;
                case 'Q':
                    int c = Integer.parseInt(st.nextToken());
                    sb.append(size[find(c)]).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return;

        size[xr] += size[yr];
        parent[yr] = xr;
    }
}