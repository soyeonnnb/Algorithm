// chat gpt 성능체크
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] dp = new int[20010];
        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int t = scanner.nextInt();
            v.add(t);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (i == j) {
                    continue;
                }
                v.add(v.get(i) + v.get(j));
            }
        }

        for (int x : v) {
            dp[x] = 1;
        }

        for (int i = 1; i < 10010; i++) {
            if (dp[i] != 0) {
                continue;
            }

            for (int j = 1; j < i; j++) {
                if (dp[j] == 0 || dp[i - j] == 0) {
                    continue;
                }

                if (dp[i] == 0) {
                    dp[i] = dp[j] + dp[i - j];
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }

            }

        }
        if (dp[N] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}