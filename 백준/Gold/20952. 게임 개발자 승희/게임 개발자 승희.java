import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16:14 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int MOD = 1000000007;
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] brr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) brr[i] = Integer.parseInt(st.nextToken());
        boolean[] removed = new boolean[7];
        int[] prefix = new int[7];
        for(int i=0;i<N;i++) prefix[(7-arr[i]%7)%7]++;
        int remain = N;
        int sum = 0;
        int idx = 0;
        for(int i=0;i<M;i++) {
            int newIdx = (brr[i] + idx)%7;
            if (prefix[newIdx] == remain) continue;
//            System.out.println(i+" "+newIdx);
            idx = newIdx;
            sum += brr[i];
            sum%=MOD;
            if (!removed[newIdx]) remain -= prefix[newIdx];
            removed[newIdx] = true;
        }
        int ans = 0 ;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            if (!removed[(7-arr[i]%7)%7]) {
                ans++;
                sb.append((arr[i]+sum)%MOD).append(" ");
            }
        }
        System.out.println(ans);
        System.out.println(sb);

    }
}