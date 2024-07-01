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
        int Q=Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] nxt = new int[N+1];
        for(int i=0;i<=N;i++) nxt[i] = i+1;
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            for(int i=a;i<=b;) {
                if (arr[i] != 0) {
                    i = nxt[i];
                    continue;
                }
                arr[i] = x;
                i = nxt[i];
            }
            nxt[a] = b+1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}