import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[200_000];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            Arrays.fill(arr, 0);
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (i <= M) arr[i + N] = arr[i];
            }
            int count = 0;
            int s = 0;
            int e = 0;
            int sum = 0;
            while(e < M) {
                sum += arr[e++];
            }
            if (sum < K) count++;
            if (N == M) {
                sb.append(count).append("\n");
                continue;
            }
            while(s < N - 1) {
                sum -= arr[s++];
                sum += arr[e++];
                if (sum < K) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}