import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int[] arr;
    private static boolean fin;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr = new int[n+1];
        fin = false;
        recur(1);
    }
    private static boolean check(int cur) {
        // cur이 마지막인 수에 대하여 길이가 i인 수열 체크하기
        for(int i=1;i<=cur/2;i++) {
            int idx1 = cur;
            int idx2 = cur-i;
            long num1 = 0;
            long num2 = 0;
            for(int j=0;j<i;j++) {
                num1 *= 10;
                num2 *= 10;
                num1 += arr[idx1--];
                num2 += arr[idx2--];
            }
            if (num1 == num2) return false;
        }
        return true;
    }
    private static void recur(int cur) {
        if (fin) return;
        // 이 전의 수까지 오는 수열에 대하여 좋은 수열인지만 판단.
        if (cur > 2 && !check(cur-1)) return;

        if (cur == n+1) {
            fin=true;
            for(int i=1;i<=n;i++) System.out.print(arr[i]);
            return;
        }
        for(int i=1;i<=3;i++) {
            arr[cur] = i;
            recur(cur+1);
        }
    }
}