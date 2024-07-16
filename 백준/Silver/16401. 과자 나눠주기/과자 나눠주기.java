import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int s = 1;
        int e = 1;
        for(int i=0;i<N;i++) e = Math.max(e, arr[i]);
        int ans = 0;
        while(s <= e) {
            int mid = (s+e) / 2;
            int sum = 0;
            for(int i=0;i<N;i++) {
                sum += arr[i]/mid;
                if (sum >= M) break;
            }
            if (sum < M) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}