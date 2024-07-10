import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = i;
            min = new int[getTreeSize(N)];
            max = new int[getTreeSize(N)];
            minInit(0, N-1, 1);
            maxInit(0, N-1, 1);

            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (q == 0) {
                    if (a == b) continue;
                    updateMin(0, N-1, 1, a, arr[b]);
                    updateMin(0, N-1, 1, b, arr[a]);
                    updateMax(0, N-1, 1, a, arr[b]);
                    updateMax(0, N-1, 1, b, arr[a]);
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;

                } else {
                    int min = getMin(0, N-1, 1, a, b);
                    int max = getMax(0, N-1, 1, a, b);
                    if (min < a || min > b || max < a || max > b) sb.append("NO");
                    else sb.append("YES");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int getTreeSize(int N) {
        int h = (int) Math.ceil(Math.log(N) /Math.log(2))+1;
        return (int) Math.pow(2, h)+1;
    }

    private static int minInit(int start, int end, int node) {
        if (start == end) return min[node] = arr[start];

        int mid = (start + end)/2;
        return min[node] = Math.min(minInit(start, mid, node*2), minInit(mid+1, end, node*2+1));
    }

    private static int maxInit(int start, int end, int node) {
        if (start == end) return max[node] = arr[start];

        int mid = (start + end)/2;
        return max[node] = Math.max(maxInit(start, mid, node*2), maxInit(mid+1, end, node*2+1));
    }

    private static int updateMin(int start, int end, int node, int idx, int change) {
        if (start > idx || end < idx) return min[node];
        if (start == end) return min[node] = change;

        int mid = (start + end) / 2;
        return min[node] = Math.min(updateMin(start, mid, node*2, idx, change), updateMin(mid+1, end, node*2+1, idx, change));
    }

    private static int updateMax(int start, int end, int node, int idx, int change) {
        if (start >idx || end < idx) return max[node];
        if (start == end) return max[node] = change;

        int mid = (start + end) / 2;
        return max[node] = Math.max(updateMax(start, mid, node*2, idx, change), updateMax(mid+1, end, node*2+1, idx, change));
    }

    private static int getMin(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return 100001;
        if (l <= start && end <= r) return min[node];

        int mid = (start + end)/2;
        return Math.min(getMin(start, mid, node*2, l, r), getMin(mid+1, end, node*2+1, l, r));
    }

    private static int getMax(int start, int end, int node, int l, int r) {
        if (start > r || end < l) return -1;
        if (l <= start && end <= r) return max[node];

        int mid = (start + end)/2;
        return Math.max(getMax(start, mid, node*2, l, r), getMax(mid+1, end, node*2+1, l, r));
    }

}