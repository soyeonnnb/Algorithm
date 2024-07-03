import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] dp;
    private static int[] beads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[501][501][2];
        for(int i=0;i<=500;i++) for(int j=0;j<=500;j++) Arrays.fill(dp[i][j], -1);

        beads = new int[3];
        for(int i=0;i<3;i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        for(int tc=1;tc<=5;tc++) {
            st = new StringTokenizer(br.readLine());
            int k1=Integer.parseInt(st.nextToken());
            int k2=Integer.parseInt(st.nextToken());
            System.out.println(recur(k1, k2, 0) == 0 ? 'B' : 'A');
        }

    }

    private static int recur(int x, int y, int turn) {
        if (x < 0 || y < 0) return -1;
        if (dp[x][y][turn] != -1) return dp[x][y][turn];

        int result = Integer.MAX_VALUE;

        dp[x][y][turn] = 0;
        for(int b : beads) {
            if (x - b >= 0 && recur(x-b, y, (turn+1)%2) == 0) dp[x][y][turn] = 1;
            if (y - b >= 0 && recur(x, y-b, (turn+1)%2) == 0) dp[x][y][turn] = 1;
        }

        return  dp[x][y][turn];
    }
}