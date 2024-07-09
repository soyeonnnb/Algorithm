import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr, min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        min = new int[getTreeSize(N)];
        max = new int[getTreeSize(N)];

        maxInit(0, N-1, 1);
        minInit(0, N-1, 1);

        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=M;tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(getMin(0, N-1, 1, s, e)).append(" ")
                    .append(getMax(0, N-1, 1, s, e)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static int maxInit(int start, int end, int node) {
        if (start == end) return max[node] = arr[start];

        int mid = (start + end) / 2;
        return max[node] = Math.max(maxInit(start, mid, node*2), maxInit(mid+1, end, node*2 + 1));
    }

    private static int minInit(int start, int end, int node) {
        if (start == end) return min[node] = arr[start];

        int mid = (start + end) / 2;
        return min[node] = Math.min(minInit(start, mid, node*2), minInit(mid+1, end, node*2 + 1));
    }

    private static int getMax(int start, int end, int node, int l, int r) {
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return max[node];

        int mid = (start + end) / 2;
        return Math.max(getMax(start, mid, node * 2, l, r), getMax(mid + 1, end,node * 2 + 1, l, r));
    }

    private static int getMin(int start, int end, int node, int l, int r) {
        if (r < start || l > end) return 1000000001;
        if (l <= start && end <= r) return min[node];

        int mid = (start + end) / 2;
        return Math.min(getMin(start, mid, node * 2, l, r), getMin(mid + 1, end, node * 2 + 1, l, r));
    }

}