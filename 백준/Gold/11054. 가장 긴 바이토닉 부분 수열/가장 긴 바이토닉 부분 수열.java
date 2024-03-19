import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        int max;
        for(int i=0;i<N;i++) {
            max = 0;
            for(int j=0;j<i;j++) if (arr[i] > arr[j])  max = Math.max(max, prefix[j]);
            prefix[i] = max+1;
        }
        for(int i=N-1;i>=0;i--) {
            max = 0;
            for(int j=i+1;j<N;j++) if (arr[i] > arr[j]) max = Math.max(max, suffix[j]);
            suffix[i] = max+1;
        }
        max = 0;
        for(int i=0;i<N;i++) max = Math.max(max, prefix[i] + suffix[i] - 1);
        System.out.println(max);
    }
}