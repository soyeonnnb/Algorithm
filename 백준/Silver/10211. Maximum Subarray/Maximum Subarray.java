import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int ans = Integer.parseInt(st.nextToken());
            int sum = ans;
            for(int i=1;i<N;i++) {
                int n = Integer.parseInt(st.nextToken());
                sum = Math.max(0, sum) + n;
                ans = Math.max(ans, sum);
            }
            System.out.println(ans);
        }
    }
}