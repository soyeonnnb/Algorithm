import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20:03 ~
// DFS로 풀자 !
public class Main {
    private static int N, answer;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0;i<2;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) arr[j][i] = str.charAt(j) - '0';
        }
        answer = -1;
        dfs(1, 0);
        for(int i=0;i<=1;i++) arr[i][0] = arr[i][0] == 0 ? 1 : 0;
        dfs(1, 1);
        System.out.println(answer);
    }
    private static void dfs(int now, int count) {
        if (now == N) {
            if (arr[N-1][0] == arr[N-1][1]) answer = answer == -1 ? count : Math.min(answer, count);
            return;
        }
        if (arr[now-1][0] == arr[now-1][1]) {
            dfs(now+1, count);
        } else {
            for(int i=-1;i<=1;i++){
                if (now+i >= N) continue;
                arr[now+i][0] = arr[now+i][0] == 0 ? 1 : 0;
            }
            dfs(now+1, count+1);
            for(int i=-1;i<=1;i++){
                if (now+i >= N) continue;
                arr[now+i][0] = arr[now+i][0] == 0 ? 1 : 0;
            }
        }
    }
}