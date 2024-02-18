import java.util.Scanner;

public class Main {
    private static boolean fin;
    private static int n, k, cnt, idx;
    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        answer = new int[n];
        recur(0, 0);
        if (fin) {
            for(int i=0;i<idx;i++){
                if (i != idx-1) System.out.print(answer[i]+"+");
                else System.out.print(answer[i]);
            }
        } else System.out.println(-1);
    }
    private static void recur(int cur, int sum) {
        if (fin) return;
        if (sum == n) {
            cnt++;
            if (cnt == k) {
                fin = true;
                idx = cur;
            }
            return;
        } else if (sum > n) return;
        for(int i=1;i<=3;i++) {
            if (fin) return;
            answer[cur] = i;
            recur(cur+1, sum+i);
        }
    }
}