
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[][] dp = new int[2][3]; // 첫번째 칸에 있는 경우, 두번째 칸에 있는 경우, 둘다 없는 경우
        Arrays.fill(dp[0], 1);

        for(int i=1;i<N;i++) {
            dp[i%2][0] = (dp[(i+1)%2][1] + dp[(i+1)%2][2])%9901;
            dp[i%2][1] = (dp[(i+1)%2][0] + dp[(i+1)%2][2])%9901;
            dp[i%2][2] = (dp[(i+1)%2][0] + dp[(i+1)%2][1] + dp[(i+1)%2][2])%9901;
        }

        System.out.println((dp[(N+1)%2][0] + dp[(N+1)%2][1] + dp[(N+1)%2][2])%9901);

    }
}
