import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, H;
    private static boolean[][] ladder;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        ladder = new boolean[N+2][H+2];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[b][a] = true;
        }
        flag = false;
        for(int max=0;max<=3;max++) {
            recur(1,1, 0, max);
            if (flag) {
                System.out.println(max);
                return;
            }
        }

        System.out.println(-1);

    }

    private static void recur(int row, int col, int count, int max) {
        if (count == max) {
            if (check())
                flag = true;
            return;
        }
        if (col > H) {
            recur(row+1, 1, count, max);
            return;
        } else if (row >= N) {
            return;
        }

        // 놓거나
        // 이미 있거나 긋지 못하는 선이면
        if (!ladder[row][col] && !ladder[row+1][col] && !ladder[row-1][col]) {
            ladder[row][col] = true;
            recur(row, col+1, count+1, max);
            ladder[row][col] = false;
        }
        if (flag) return; // 더 해볼 필요 없음

        // 놓지 않거나
        recur(row, col+1, count, max);
    }


    private static boolean check() {

        // 각 사다리를 돌면서
        for(int n=1;n<=N;n++) {
            int now = n; // 현재 있는 곳
            for(int j=1;j<=H;j++) { // 한칸씩 내려오면서
                if (ladder[now][j]) { // 만약 오른쪽으로 가는 사다리 있으면
                    now++;
                } else if (ladder[now-1][j]) { // 왼쪽으로 가는 사다리가 있으면
                    now--;
                }
                // 둘다 아니면 그냥 한칸 내려오면 됨
            }
            if (now != n) return false; // 만약에 다 내려왔는데 번호가 다르면 return false;
        }

        return true;
    }
}