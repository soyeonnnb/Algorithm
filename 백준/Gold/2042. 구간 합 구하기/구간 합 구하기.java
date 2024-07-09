import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i=0;i<N;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        tree = new long[getTreeSize()];
        init(0, N-1, 1);
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=M+K;tc++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if (order == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1; // 인덱스는 0부터 시작하므로
                long change = Long.parseLong(st.nextToken());
                update(0, N-1, 1, index, change - arr[index]);

                arr[index] = change;
            } else {
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                sb.append(pSum(0, N-1, 1, start, end)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end)/2;
        return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node*2 + 1);
    }

    private static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    private static void update(int start, int end, int node, int index, long diff) { // index를 diff 만큼 수정함
        if (start <= index && index <= end) { // 만약 index가 해당 구간에 포함되어 있다면 수정
            tree[node] += diff;
        } else return; // 아니면 수정할 필요 없음

        if (start == end) return; // 리프노드임

        int mid = (start + end) / 2;
        update(start, mid, node*2, index, diff);
        update(mid+1, end, node*2+1, index, diff);
    }
    private static long pSum(int start, int end, int node, int l, int r) { // l ~ r 구간합 구하기
        if (r < start || l > end) return 0;
        else if (l <= start && end <= r) return tree[node]; // 해당 지점이 구간 합에 포함됨

        int mid = (start + end) / 2;
        return pSum(start, mid, node*2, l, r) + pSum(mid+1, end, node*2 + 1, l, r);
    }

}