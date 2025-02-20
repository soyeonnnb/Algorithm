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

        int s = 1;
        int e = 0;
        for(int i=0;i<N;i++) {
            s = Math.max(s, arr[i]);
            e += arr[i];
        }
        int ans = e;
        while(s <= e) {
            int mid = (s+e) / 2;
            int count = 0;
            int sum = 0;
            for(int i=0;i<N;i++) {
                sum += arr[i];
                if (sum == mid) {
                    count++;
                    sum = 0;
                } else if (sum > mid) {
                    sum = arr[i];
                    count++;
                }
                if (count > M) break;
            }
            if (sum != 0) count++;
            if (count <= M) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}