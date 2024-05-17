import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12:52 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[10010][10010];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            for(int i=0;i<10010;i++) Arrays.fill(arr[i], 0);
            int N=Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())+1;
                int b = Integer.parseInt(st.nextToken())+1;
                arr[a][b]++;
            }
            for(int i=0;i<10010;i++) {
                for(int j=0;j<10010;j++) {
                    if (i == 0 && j == 0) continue;
                    if (i == 0) {
                        arr[i][j] += arr[i][j-1];
                    } else if (j == 0) {
                        arr[i][j] += arr[i-1][j];
                    } else {
                        arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
                    }
                }
            }
            int ans = arr[10][10];
            for(int i=11;i<10010;i++) {
                for(int j=11;j<10010;j++) {
                    int cnt = arr[i][j] - arr[i-11][j] - arr[i][j-11] + arr[i-11][j-11];
                    ans = Math.max(ans, cnt);
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}