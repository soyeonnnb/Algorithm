import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14:34 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N+1];
        int[] suffix = new int[N+1];
        for(int i=1;i<=N;i++) {
            for(int j=0;j<i;j++) {
                if (arr[i] > arr[j]) prefix[i] = Math.max(prefix[i], prefix[j]);
            }
            prefix[i]++;
        }
        for(int i=N;i>=1;i--) {
            for(int j=i+1;j<=N;j++) {
                if (arr[i] < arr[j]) suffix[i] = Math.max(suffix[i], suffix[j]);
            }
            suffix[i]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(prefix[q] + suffix[q] - 1).append("\n");
        }
        System.out.println(sb);
    }
}