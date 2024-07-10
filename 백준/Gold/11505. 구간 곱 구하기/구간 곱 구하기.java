import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static long[] arr, tree;
    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(br.readLine());
        tree = new long[getTreeSize(N)];
        init(0, N-1, 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(0, N-1, 1, b, c%MOD);
            } else {
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(mul(0, N-1,1, b, c)%MOD).append("\n");
            }
        }
        System.out.println(sb);
    }

    // 트리 사이즈 구하기
    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2 + 1))%MOD;
    }

    private static long update(int start, int end, int node, int idx, long update) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = update; // 만약 리프노드면

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, update) * update(mid+1, end, node*2+1, idx, update))%MOD;
    }

    // 곱 결과 구하기
    private static long mul(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return 1;
        else if (l <= start && end <= r) return tree[node];

        int mid = (start + end)/2;
        return (mul(start, mid, node * 2, l, r) * mul(mid+1, end, node*2+1, l, r))%MOD;
    }

}