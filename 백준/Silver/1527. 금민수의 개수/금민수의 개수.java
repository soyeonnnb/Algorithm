

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] arr;
    private static int ans, A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[10];
        A=sc.nextInt();
        B=sc.nextInt();
        ans = 0;
        recur(0);
        System.out.println(ans);
    }

    private static void recur(int index) {
        if (index >= 10) return;
        int now = makeNum(index);
        if (now >= A && now <= B) {
            ans++;
        }
        arr[index] = 4;
        recur(index+1);
        arr[index] = 7;
        recur(index + 1);
    }

    private static int makeNum(int index) {
        int result = 0;
        for(int i=0;i<index;i++) {
            result*=10;
            result+=arr[i];
        }
        return result;
    }
}
