
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
        long sum = 0;
        for(int i=0;i<N;i++) {
            long input = Long.parseLong(st.nextToken());
            arr[i] = input;
            sum += input;
        }
        long ans = 0;
        for(int i=0;i<N;i++) {
            ans += arr[i] * (sum - arr[i]);
            ans %= 1_000_000_007;
            sum -= arr[i];
        }
        System.out.println(ans);
    }
}
