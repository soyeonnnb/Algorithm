import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();

        for(int i=1;i<=N;i++) {
            String[] str = br.readLine().split(" ");
            list[i].add(0);
            for(String s : str) list[i].add(Integer.parseInt(s));
        }

        int[][] dp = new int[N+1][H+1];
        dp[0][0] = 1;

        for(int i=1;i<=N;i++) {
            for(int j=0;j<=H;j++) {
                for(int height:list[i]) {
                    if (j < height) continue;
                    dp[i][j] += dp[i-1][j-height];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][H]);
    }
}