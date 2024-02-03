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
        int[] arr = new int[M];
        for(int i=0;i<M;i++) arr[i] = Integer.parseInt(br.readLine());
        long s = 1;
        long e = 0;
        for(int i=0;i<M;i++) e = Math.max(e, arr[i]);
        long answer = e;

        while(s<=e) {
            long mid = (s+e)/2;
            long sum = 0;
            for(int i=0;i<M;i++) {
                sum += arr[i]/mid;
                if (arr[i]%mid!=0) {
                    sum++;
                }
            }
            if (sum <= N) {
                e= mid-1;
                answer = Math.min(answer, mid);
            } else {
                s = mid+1;
            }
        }
        System.out.println(answer);
    }
}