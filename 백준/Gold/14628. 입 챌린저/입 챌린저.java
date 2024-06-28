import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K, ans;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MAX_VALUE;
        recur(M, 0, 0);
        System.out.println(ans);
    }
    private static void recur(int remain, int point, int last) {
        if (remain<0) return;
        else if (remain == 0) {
            ans = Math.min(ans, point);
            return;
        }
        else if (point > ans) return;

        for(int i=last;i<N;i++) {
//            System.out.println(i+" "+remain+" "+point);
            if (remain < arr[i][1]) continue;
            arr[i][0] += K;
            recur(remain - arr[i][1], point + arr[i][0] - K, i);
            arr[i][0] -= K;
        }
    }
}