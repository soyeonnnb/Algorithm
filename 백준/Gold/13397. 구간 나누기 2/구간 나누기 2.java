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
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int MIN = 10001;
        int MAX = 0;
        for(int i=0;i<N;i++) {
            MIN = Math.min(MIN, arr[i]);
            MAX = Math.max(MAX, arr[i]);
        }
        int s = 0;
        int e = MAX - MIN;
        int ans = MAX - MIN;
        while(s <= e) {
            int mid = (s+e)/2;
            int count = 1;
            int min = arr[0];
            int max = arr[0];
            for(int i=1;i<N;i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                if (max - min > mid) {
                    count++;
                    min = arr[i];
                    max = arr[i];
                }
            }
            if (count > M) {
                s = mid + 1;
            } else {
                e = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}