import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N+1];
        for(int i=1;i<=N;i++) {
            char ch = br.readLine().charAt(0);
            switch (ch){
                case 'H':
                    arr[0][i]++;
                    break;
                case 'P':
                    arr[1][i]++;
                    break;
                case 'S':
                    arr[2][i]++;
                    break;
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=1;j<=N;j++) arr[i][j] += arr[i][j-1];
        }

        int answer = 0;
        for(int i=0;i<=N;i++) {
            for(int j=0;j<3;j++) {
                for(int k=0;k<3;k++) {
                    if (j == k) continue;
                    answer = Math.max(answer, arr[j][i] + arr[k][N] - arr[k][i]);
                }
            }
        }
        System.out.println(answer);


    }
}