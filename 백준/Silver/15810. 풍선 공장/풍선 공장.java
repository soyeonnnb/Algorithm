import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        long s = 0;
        long e = Long.MAX_VALUE;
        for(int i=0;i<N;i++) e = Math.min(e, arr[i]);
        e *= M;
        long ans = e;
        while(s <= e) {
            long mid = (s+e) / 2;
            long count = 0;
            for(int i=0;i<N;i++) count += mid / arr[i];
            if (count >= M) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}