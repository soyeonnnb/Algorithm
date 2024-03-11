import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N, num;
    private static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        result = new int[N+1];
        Arrays.fill(result, 100000);
        num = 1;
        while(num*num <= N) {
            result[num * num] = 1;
            num++;
        }
        num--;
        System.out.println(recur(N));

    }
    public static int recur(int cur) {
        if (cur < 0) return -1;
        else if (result[cur] != 100000) return result[cur];

        for(int i=1;i <= num;i++) {
            int re = recur(cur - i*i);
            if (re < 0) break;
            result[cur] = Math.min(result[cur], re + 1);
        }
        return result[cur];
    }
}