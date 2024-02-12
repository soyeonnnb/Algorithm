import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 100000000;
        for(int i=0;i<N;i++) {
            int min1 = -1;
            int min2 = -1;
            for(int j=0;j<N;j++) {
                if (i == j) continue;
                int cal = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) +Math.abs(arr[i][2] - arr[j][2]);
                if (min1 == -1) {
                    min1 = cal;
                } else if (min2 == -1) {
                    min2 = cal;
                    if (min2 < min1) {
                        int temp = min1;
                        min1 = min2;
                        min2 = temp;
                    }
                } else if (min1 >= cal) {
                    min2 = min1;
                    min1 = cal;
                } else if (min2 > cal) {
                    min2 = cal;
                }
            }
            answer = Math.min(answer, min1+min2);
        }
        System.out.println(answer);
    }
}