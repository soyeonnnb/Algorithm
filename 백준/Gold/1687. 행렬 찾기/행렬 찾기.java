import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            String str = br.readLine();
            for(int j=1;j<=M;j++) arr[i][j] = str.charAt(j-1) == '0' ? 0 : 1;
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
        }

        int answer = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++) {
                outer: for(int a=i;a>=1;a--) {
                    for(int b=j;b>=1;b--) {
                        if (arr[i][j] - arr[a-1][j] - arr[i][b-1] + arr[a-1][b-1] == 0) {
                           answer = Math.max(answer, (i-a+1)*(j-b+1));
                        } else continue outer;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}