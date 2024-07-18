import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        tree = new int[getTreeSize(N)];
        init(0, N-1, 1);

        int M=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 1) {
                update(0, N-1, 1, a-1, b%2);
            } else if (q == 2) {
                sb.append(b-a+1-pSum(0, N-1, 1, a-1, b-1)).append("\n");
            } else {
                sb.append(pSum(0, N-1, 1, a-1, b-1)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int pSum(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return 0;
        else if (l <= start && end <= r) return tree[node];

        int mid = (start + end)/2;
        return pSum(start, mid, node*2, l, r) + pSum(mid+1, end, node*2+1, l, r);
    }

    private static int update(int start, int end, int node, int idx, int num) {
        if (start > idx || end < idx) return tree[node];
        else if (start == end) return tree[node] = num;

        int mid = (start + end)/2;
        return tree[node] = update(start, mid, node*2, idx, num) + update(mid+1, end, node*2+1, idx, num);
    }

    private static int init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start]%2;

        int mid = (start + end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }
}