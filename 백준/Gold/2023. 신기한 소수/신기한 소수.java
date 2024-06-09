import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb;
    private static int[] dp;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dp = new int[N+1];
        for(int i=1;i<=9;i++) {
            if(!prime(i)) continue;
            dp[1] = i;
            recur(2);
        }
        System.out.println(sb);
    }

    private static void recur(int loca) {
        if(loca > N) {
            sb.append(getNum(N)).append("\n");
            return;
        }

        for(int i=0;i<=9;i++) {
            dp[loca] = i;
            if (!prime(getNum(loca))) continue;
            recur(loca+1);
        }
    }

    private static int getNum(int loca) {
        int result = 0;
        for(int i=1;i<=loca;i++) {
            result *= 10;
            result += dp[i];
        }
        return result;
    }

    private static boolean prime(int x) {
        if (x == 0 || x == 1) return false;
        if(x == 2 || x == 3) return true;
        for(int i=2;i*i<=x;i++) {
            if (x%i == 0) return false;
        }
        return true;
    }
}