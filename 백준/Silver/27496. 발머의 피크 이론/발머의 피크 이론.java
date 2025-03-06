import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        int s = 0;
        int e = 0;
        int sum = 0;
        while(e < L) {
            sum += arr[e++];
            if (sum >= 129 && sum <= 138) ans++;
        }
        while(e < N) {
            sum += arr[e++];
            sum -= arr[s++];
            if (sum >= 129 && sum <= 138) ans++;
        }
        System.out.println(ans);
    }
}
