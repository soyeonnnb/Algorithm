import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 16:20 ~
public class Main {
    private static int max, N, height;
    private static int[] arr;
    private static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height=Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, (height+1)) - 1;
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans += arr[i];
        }
        dfs(1, 0, 0);
        dfs2(1, 0, 0);

        System.out.println(ans);
    }
    private static void dfs(int cur, int h, int sum) {
        if (h == height) {
            max = Math.max(max, sum);
            return;
        }
        dfs(cur*2, h+1, sum+arr[cur*2]);
        dfs(cur*2+1, h+1, sum+arr[cur*2+1]);
    }

    private static int dfs2(int cur, int h, int sum) {
        if (h == height) {
            return max - sum;
        }
        int l = dfs2(cur*2, h+1, sum+arr[cur*2]);
        int r = dfs2(cur*2+1, h+1, sum+arr[cur*2+1]);

        int re = Math.min(l, r);


        ans += r - re;
        ans += l - re;

        return re;

    }
}