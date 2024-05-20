import java.util.Arrays;
import java.util.Scanner;

// 13:50 ~
public class Main {
    private static int count , N;
    private static long ans;
    private static boolean finished;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        int[] arr = new int[10];
        int idx = 0;
        ans = -1;
        count = -1;
        finished = false;
        for(int maxIdx = 0;maxIdx < 10;maxIdx ++) {
            recur(0, maxIdx, arr);
            if (finished) break;
        }
        System.out.println(ans);
    }
    private static void recur(int nowIdx, int maxIdx, int[] arr) {
        if (finished) return;
        if (nowIdx > maxIdx) {
            count++;
            if (count == N) {
                finished = true;
                long num = 0;
                for(int i=0;i<=maxIdx;i++) {
                    num *= 10;
                    num += arr[i];
                }
                ans = num;
            }
            return;
        }
        for(int i=0;i<=9;i++) {
            if (nowIdx == 0 || arr[nowIdx-1] > i) {
                arr[nowIdx] = i;
                recur(nowIdx+1, maxIdx, arr);
            }
            if (finished) return;
        }

    }

}