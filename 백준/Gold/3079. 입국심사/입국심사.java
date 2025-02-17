import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        long M=Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(br.readLine());
        long s = 1L;
        long min = Long.MAX_VALUE;
        for(int i=0;i<N;i++) min = Math.min(min, arr[i]);
        long e = min * M;
        long ans = Long.MAX_VALUE;
        while(s <= e){
            long mid = (s + e)/2;
            long sum = 0;
            for(int i=0;i<N;i++) sum +=mid/arr[i];
            if (sum < M) {
                s = mid+1;
            } else {
                ans = Math.min(ans, mid);
                e = mid-1;
            }
        }
        System.out.println(ans);
    }
}