import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12:23 ~
public class Main {
    private static int N, K, C;
    private static long ans;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        ans = -1;
        recur(0, C);
        System.out.println(ans);
    }

    private static long getCount(long mid) {
        long count =0 ;
        for(int i=0;i<N;i++) count += mid/arr[i];
        return count;
    }

    private static void recur(int cur, int remainC) {
        if (cur == N || remainC == 0) {
            long s = 0L;
            long e = 1000000000000L;
            while(s<=e) {
                long mid = (s+e)/2;
                long num = getCount(mid);
                if (num >= K) {
                    ans = ans == -1 ? mid : Math.min(ans, mid);
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            }
            return;
        }

        // 현재 요리사를 줄이는 경우
        if (arr[cur] > 1) {
            arr[cur]--;
            recur(cur, remainC-1);
            arr[cur]++;
        }
        // 현재 요리사를 줄이지 않는 경우
        recur(cur+1, remainC);
    }
}