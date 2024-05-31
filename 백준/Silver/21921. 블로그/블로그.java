import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());
        long[] prefix = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) prefix[i] = Long.parseLong(st.nextToken());
        for(int i=1;i<=N;i++) prefix[i] += prefix[i-1];
        long ans = 0;
        int count = 0;
        for(int i=X;i<=N;i++) {
            long num = prefix[i] - prefix[i-X];
            if (ans < num) {
                ans = num;
                count = 1;
            } else if (ans == num) {
                count++;
            }
        }

        if (ans == 0) System.out.println("SAD");
        else System.out.println(ans+"\n"+count);
    }
}