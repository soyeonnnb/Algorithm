import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, A, B, ans;
    private static int[][] arr;
    private static int[][][][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N+1][4];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = new int[N+5][N+5][N+5][2]; // 날짜, a, b, 게임
        for(int i=1;i<=N;i++) for(int j=0;j<=N;j++) for(int k=0;k<=N;k++) Arrays.fill(answer[i][j][k], -1);
        int ans = 0;
        for(int i=0;i<=A;i++) for(int j=B;j<=N;j++) for(int k=0;k<2;k++) {
            ans = Math.max(ans,recur(N, i, j, k));
//            System.out.println(recur(N, i, j, k));
        }
        System.out.println(ans);

    }
    private static int recur(int cur, int a, int b, int type) {
        if (a < 0 || b < 0) return -100000000;
        else if (cur < 0) return -100000000;
        else if (cur == 0) {
            if (a != 0 || b != 0) return -100000000;
            else return 0;
        }
        else if (answer[cur][a][b][type] != -1) return answer[cur][a][b][type];
        // game = 0 => 전날 휴게실 아닌 경우, 1 => 전날 휴게실 사용한 경우
        int study = Math.max(recur(cur-1, a, b-1, 0), recur(cur-1, a, b-1, 1))+ Math.max(arr[cur][0], arr[cur][1]);
        int play = Math.max(recur(cur-1, a-1, b, 0), recur(cur-1, a-1, b, 1)) + arr[cur][3];
        answer[cur][a][b][0] = Math.max(study, play);
        answer[cur][a][b][1] = recur(cur-1, a, b, 0) + arr[cur][2];
        return answer[cur][a][b][type];
    }

}