
import java.util.Scanner;

public class Main {

    private static int N, M, ans;
    private static boolean[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        arr = new boolean[N][M];
        recur(0, 0);
        System.out.println(ans);
    }

    private static void recur(int i, int j) {
        if (i == N) {
            ans++;
            return;
        } else if (j == M) {
            recur(i+1, 0);
            return;
        }

        // 안하는 경우
        recur(i, j+1);

        // 할 수 있는지 체크
        if (can(i, j)) {
            arr[i][j] = true;
            recur(i, j+1);
            arr[i][j] = false;
        }
    }

    private static boolean can(int i, int j) {
        if (i == 0 || j == 0) return true;
        else if (arr[i-1][j] && arr[i][j-1] && arr[i-1][j-1]) return false;
        else return true;
    }
}
