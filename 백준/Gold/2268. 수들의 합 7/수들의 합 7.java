import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        tree = new long[getTreeSize(N)];

        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 0) {
                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                sb.append(pSum(0, N-1, 1, a-1, b-1)).append("\n");
            } else {
                update(0, N-1, 1, a-1, b);
            }
        }
        System.out.println(sb);

    }

    private static long update(int start, int end, int node, int idx, int num) {
        if (start > idx || end < idx) return tree[node];

        else if (start == end) return tree[node] = num;

        int mid = (start+end)/2;
        return tree[node] = update(start, mid, node*2, idx, num) + update(mid+1, end, node*2+1, idx, num);
    }

    private static long pSum(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return 0;
        else if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2 ;
        return pSum(start, mid, node*2, l, r) + pSum(mid+1, end, node*2+1, l, r);
    }


    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

}