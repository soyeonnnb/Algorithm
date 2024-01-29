import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] arr = new int[N+1][N+1][11];
        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j][num]++;
            }
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                for(int k=1;k<=10;k++) {
                    arr[i][j][k] += arr[i-1][j][k] + arr[i][j-1][k] - arr[i-1][j-1][k];
                }
            }
        }
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int q=1;q<=Q;q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = 0;
            for(int k=1;k<=10;k++) {
                if (arr[x2][y2][k] - arr[x2][y1-1][k] - arr[x1-1][y2][k] + arr[x1-1][y1-1][k] > 0) answer++;
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);


    }
}