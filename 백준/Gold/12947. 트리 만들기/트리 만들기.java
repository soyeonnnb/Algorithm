import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12:01 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr =new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        int root = 0;
        for(int i=1;i<=N;i++) {
            if (arr[i] == 1) {
                ans = Math.max(ans, (i-root -1) + (N-root));
                root = i;
            } else {
                ans = Math.max(ans, (i-root) * 2);
            }
        }
        System.out.println(ans);
    }
}