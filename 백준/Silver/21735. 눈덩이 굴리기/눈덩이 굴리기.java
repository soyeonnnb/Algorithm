

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        arr[0] = 1;
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        sum = new int[N+1][M+1];
        sum[0][0] = 1;
        recur(0, 0, 1);
        int ans = 0;
        for(int i=0;i<=N;i++) for(int j=0;j<=M;j++) ans = Math.max(ans, sum[i][j]);
//        for(int i=0;i<=N;i++) System.out.println(Arrays.toString(sum[i]));
        System.out.println(ans);
    }
    private static void recur(int location, int time, int size) {
        if (time  == M) {
            return;
        }

        // 한칸 앞으로 가기
        if (location + 1 > N) return;
        int go = size + arr[location+1];
        if (sum[location+1][time+1] < go) {
            sum[location+1][time+1] = go;
            recur(location+1, time+1, go);
        }

        // 두칸 가기
        if (location + 2 > N) return;
        go = size/2 + arr[location+2];
        if (sum[location+2][time+1] < go) {
            sum[location+2][time+1] = go;
            recur(location+2, time+1, go);
        }
    }
}
