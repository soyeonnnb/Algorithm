import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        if (K == 1) {
            System.out.println(arr[N-1]);
            return;
        }
        int s = 0;
        int e = N-2;
        long ans = arr[N-1];
        int count = 1;
        while(count < K) {
            if (count+2 <= K) {
                ans += arr[e] - arr[s];
                e--;
                s++;
                count+=2;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}