import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] inputs = new int[4][n];
            for(int i=0;i<4;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) inputs[i][j] = Integer.parseInt(st.nextToken());
            }
            int[][] arr = new int[2][n*n];
            int idx = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    arr[0][idx] = inputs[0][i] + inputs[1][j];
                    arr[1][idx] = inputs[2][i] + inputs[3][j];
                    idx++;
                }
            }
            for(int i=0;i<2;i++)
                Arrays.sort(arr[i]);

//            System.out.println(Arrays.toString(arr));
            int s = 0;
            int e = n * n - 1;
            int answer = 100000000;
            while(s < n*n && e >= 0) {
                int sum = arr[0][s] + arr[1][e];
                if (Math.abs(k-answer) == Math.abs(k-sum)) {
                    if (sum <= answer) answer = sum;
                } else if (Math.abs(k-answer) > Math.abs(k - sum)) answer = sum;
                if (sum < k) {
                    s++;
                } else if (sum > k) {
                    e--;
                } else {
                    break;
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
}