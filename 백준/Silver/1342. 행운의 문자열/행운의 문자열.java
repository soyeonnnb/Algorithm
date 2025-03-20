
import java.util.Scanner;

public class Main {
    private static int[] arr;
    private static int N, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        N=str.length();
        arr = new int[26];
        for(int i=0;i<N;i++) arr[str.charAt(i) - 'a'] ++;

        recur(0, -1);
        System.out.println(ans);
    }

    private static void recur(int idx, int before) {
        if (idx == N) {
            ans ++;
            return;
        }

        for(int i=0;i<26;i++) {
            if (before == i || arr[i] == 0) continue;
            arr[i]--;
            recur(idx+1, i);
            arr[i]++;
        }

    }

}
