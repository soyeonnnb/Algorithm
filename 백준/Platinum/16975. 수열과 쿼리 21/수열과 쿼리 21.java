import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());

        tree = new long[getTreeSize(N)];

        StringBuilder sb = new StringBuilder();

        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(0, N-1, 1, a, k);
                update(0, N-1, 1, b, k*-1);
            } else {
                int x = Integer.parseInt(st.nextToken())-1;
                sb.append(arr[x] + sum(0, N-1, 1, 0, x)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static void update(int start, int end, int node, int idx, int update) {
        if (start <= idx && idx <= end) {
            tree[node] += update;
        } else return;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node*2, idx, update);
        update(mid+1, end, node*2+1, idx, update);
    }

    private static long sum(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return 0;
        else if (l <= start && end <= r) return tree[node];

        int mid = (start + end)/2;
        return sum(start, mid, node*2, l, r) + sum(mid+1, end, node*2+1, l, r);
    }
}