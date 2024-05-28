import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());
        long ans = 0;
        int s = 0; // 마이너스
        int e = 0; // 플러스
        while(s < N && arr[s] >= 0) s++;
        while(e < N && arr[e] <= 0) e++;
        while(s < N && e < N) {
            if (arr[s] >= 0) {
                s++;
                continue;
            }
            if (arr[e] <= 0) {
                e++;
                continue;
            }
            long sell = Math.min(arr[s] * -1, arr[e]);
            ans += sell * Math.abs(s - e);
            arr[s] += sell;
            arr[e] -= sell;
        }
        System.out.println(ans);

    }
}