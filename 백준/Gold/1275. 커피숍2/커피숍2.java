import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static long[] arr;
    private static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());
        tree = new long[getTreeSize(N)];

        init(0, N-1, 1);

        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            int a = Integer.parseInt(st.nextToken())-1;
            long b = Long.parseLong(st.nextToken());
            sb.append(sum(0, N-1, 1, x, y)).append("\n");
            update(0, N-1, 1, a, b - arr[a]);
            arr[a] = b;
        }

        System.out.println(sb);
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    private static void update(int start, int end, int node, int idx, long update) {
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

        int mid = (start + end) / 2;
        return sum(start, mid, node*2, l, r) + sum(mid+1, end, node*2+1, l, r);
    }

}