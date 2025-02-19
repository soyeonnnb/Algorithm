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
        int s = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            s = Math.max(arr[i], s);
        }
        int e = s * N;
        int ans = e;
        while(s <= e) {
            int mid = (s+e) / 2;
            int count = 0;
            int remain = mid;
            for(int i=0;i<N;i++) {
                remain -= arr[i];
                if (remain < 0) {
                    remain = mid - arr[i];
                    count++;
                }
            }
            if (remain != mid) count++;
            if (count <= M) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);


    }
}