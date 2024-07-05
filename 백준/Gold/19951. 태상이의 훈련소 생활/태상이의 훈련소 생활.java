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

        int[] arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N+2];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            prefix[s] += h;
            prefix[e+1] -= h;
        }
        for(int i=1;i<=N;i++) prefix[i] += prefix[i-1];

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(arr[i]+prefix[i]).append(" ");
        }
        System.out.println(sb);

    }
}