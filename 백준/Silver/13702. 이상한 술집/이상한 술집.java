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
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        long answer = 0;
        long s = 1;
        long e = 1;
        for(int i=0;i<N;i++) e = Math.max(e, arr[i]);
        while(s<=e) {
            long mid = (s+e)/2;
            long sum = 0;
            for(int i=0;i<N;i++) sum += arr[i]/mid;
            if (sum < K) {
                e = mid-1;
            } else if (sum >= K) {
                answer = mid;
                s = mid+1;
            }
        }
        System.out.println(answer);

    }
}