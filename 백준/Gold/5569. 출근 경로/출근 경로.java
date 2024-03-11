import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int W, H;
    private static int[][][][] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        answer = new int[W+1][H+1][2][2];
        for(int i=1;i<=W;i++) for(int j=1;j<=H;j++) for(int k=0;k<2;k++) Arrays.fill(answer[i][j][k], -1);
        for(int i=1;i<=W;i++) {
            answer[i][1][0][0] = 0;
            answer[i][1][0][1] = 1;
            answer[i][1][1][0] = 0;
            answer[i][1][1][1] = 0;
        }
        for(int i=1;i<=H;i++) {
            answer[1][i][1][0] = 0;
            answer[1][i][1][1] = 1;
            answer[1][i][0][0] = 0;
            answer[1][i][0][1] = 0;
        }

        System.out.println((recur(W, H, 0, 0) + recur(W, H, 0, 1)+recur(W, H, 1, 0)+recur(W, H, 1, 1))%100000);
    }
    private static int[] dx = new int[]{-1, 0};
    private static int[] dy = new int[]{0, -1};
    private static int recur(int w, int h, int dire, int go) {
        if (w < 1 || h < 1) return 0;
        else if (answer[w][h][dire][go] != -1) return answer[w][h][dire][go]%100000;

        if (go == 0) {
            answer[w][h][dire][go] = recur(w + dx[dire], h + dy[dire], (dire+1)%2, 1)%100000;
        } else {
            answer[w][h][dire][go] = (recur(w + dx[dire], h + dy[dire], dire, 0) + recur(w + dx[dire], h + dy[dire], dire, 1))%100000;
        }
        return answer[w][h][dire][go]%100000;
    }
}