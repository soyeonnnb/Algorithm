
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] arr = new int[1_000_001];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] += g;
        }
        for(int i=1;i<=1000_000;i++) arr[i] += arr[i-1];
        if (K >= 500_000) {
            System.out.println(arr[1000_000]);
            return;
        }
        K *= 2;
        int ans = arr[K];
        for(int i=K+1;i<=1000_000;i++) {
            ans = Math.max(ans, arr[i] - arr[i-K-1]);
        }
        System.out.println(ans);
    }
}
