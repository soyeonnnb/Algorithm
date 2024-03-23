import java.util.Scanner;

// 15:22 ~
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        boolean[] isPrime = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            if (prime(i)) isPrime[i] = true;
        }
        long answer = 0;
        for(int i=1;i<=N;i++) {
            if (isPrime[i]) { // 만약 소수이면 어느 수랑도 서로소 => 걍 그 수를 더함
                answer += i;
                continue;
            } else if (i%2 == 0) {
                answer += 2;
                continue;
            }
            // 두 번호의 최대공약수가 최소려면 그 수의 최소인 약수여야 함
            for(int j=2;j*j<=i;j++) {
                if (i%j == 0) {
                    answer += j;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    private static boolean prime(int x) {
        if (x == 1) return false;
        else if (x == 2 || x == 3) return true;
        for(int i=2;i*i<=x;i++) if (x%i == 0) return false;
        return true;
    }
}