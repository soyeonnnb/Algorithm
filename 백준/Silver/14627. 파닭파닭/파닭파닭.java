import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        int[] arr = new int[S];
        for(int i=0;i<S;i++) arr[i] = Integer.parseInt(br.readLine());
        int s = 1;
        int e = 1_000_000_000;

        long ans = 0;
        while(s <= e) {
            int mid = (s+e)/2;
            int count = 0;
            long remain = 0;
            for(int i=0;i<S;i++) {
                count += arr[i] / mid;
                remain += arr[i] % mid;
            }
            if (count < C) {
                e = mid - 1;
            } else {
                ans = remain + (count - C) * mid;
                s = mid + 1;
            }
        }
        System.out.println(ans);

    }
}