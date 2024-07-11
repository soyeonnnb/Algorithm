import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        tree = new int[getTreeSize(N)][2];

        init(0, N-1, 1);

        int M=Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 1) {
                update(0, N-1, 1, a-1, b);
            } else {
                sb.append(get(0, N-1, 1, a-1, b-1)[1]).append("\n");
            }
        }

        System.out.println(sb);
    }
    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static int[] init(int start, int end, int node) {
        if (start == end) return tree[node] = new int[]{arr[start], start + 1};

        int mid = (start + end)/2;
        int[] l = init(start, mid, node*2);
        int[] r = init(mid+1, end, node*2+1);

        return tree[node] = compare(l, r);
    }

    private static int[] temp = new int[]{1_000_000_010, 1_000_000};

    private static int[] update(int start, int end, int node, int idx, int update) {
        if (idx < start || idx > end) return tree[node];

        if (start == end) {
            tree[node][0] = update;
            return tree[node];
        }

        int mid = (start + end)/2;
        int[] l = update(start, mid, node*2, idx, update);
        int[] r = update(mid+1, end, node*2+1, idx, update);

        return tree[node] = compare(l, r);
    }

    private static int[] compare(int[] a, int[] b) {
        if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1])) {
            return a;
        } else {
            return b;
        }
    }

    private static int[] get(int start, int end, int node, int l, int r) {
        if (r < start || l > end) return temp;
        else if (l <= start && end <= r) return tree[node];

        int mid = (start + end)/2;
        int[] a = get(start, mid, node*2, l, r);
        int[] b = get(mid+1, end, node*2+1, l, r);

        return compare(a, b);
    }
}