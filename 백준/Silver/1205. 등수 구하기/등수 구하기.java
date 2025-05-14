
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        if (N != 0) {
            st = new StringTokenizer(br.readLine());
        }
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[N] = -1;
        int ans = -1;
        int same = -1;
        for(int i=0;i<=N;i++) {
            if (arr[i] == score) {
                if (same == -1) same = i+1;
            }
            if (arr[i] < score) {
                ans = i + 1;
                break;
            }
        }
        if (ans == -1) {
            System.out.println(-1);
        } else if (ans <= P) {
            if (same != -1) {
                System.out.println(same);
            } else {
                System.out.println(ans);
            }
        } else {
            System.out.println(-1);
        }
    }
}
