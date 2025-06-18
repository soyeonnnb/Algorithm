

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            for(int i=1;i<=N;i++) {
                int nxt = Integer.parseInt(br.readLine());
                arr[i] = nxt;
            }
            int now = 1;
            int count = 1;
            int ans = 0;
            while(arr[now] != -1) {
                int nxt = arr[now];
                arr[now] = -1;
                if (nxt == N) {
                    ans = count;
                    break;
                }
                now = nxt;
                count++;
            }
            System.out.println(ans);
        }
    }
}
