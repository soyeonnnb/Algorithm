import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12:16 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] < o2[0] ? -1 : 1);
        int s = 0;
        int e = 0;
        long answer = arr[0][1];
        long sum = arr[0][1];
        while(e < N) {
            if (arr[e][0] - arr[s][0] < D) {
                answer = Math.max(answer, sum);
                e++;
                if (e < N)
                    sum += arr[e][1];
            } else {
                sum -= arr[s][1];
                s++;
            }
        }
        System.out.println(answer);
    }
}
