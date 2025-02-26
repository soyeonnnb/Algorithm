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
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[N] = 0;
        arr[N+1] = L;
        Arrays.sort(arr);
        int s = 1;
        int e = L + 1;
        int ans = L;
        while(s <= e) {
            int count = 0;
            int mid = (s+e) /2;
            for(int i=1;i<N+2;i++) {
                count += (arr[i] - arr[i-1]) / mid - 1;
                if ((arr[i] - arr[i-1])%mid != 0) count++;
            }
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