import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);

        int sum = arr[0][0];
        int count = 1;
        int ans = sum >= M ? arr[0][1] : Integer.MAX_VALUE;

        for(int i=1;i<N;i++) {
            sum += arr[i][0];
            if (arr[i][1] == arr[i-1][1]) count++;
            else count = 1;
            if (sum >= M) {
                ans = Math.min(ans, count * arr[i][1]);
            }
        }
        System.out.println(sum < M ? -1 : ans);
    }
}