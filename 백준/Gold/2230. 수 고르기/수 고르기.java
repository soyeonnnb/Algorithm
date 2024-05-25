import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] =Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int s = 0;
        int e = 1;
        int ans = 2000000000;
        while(s < N && e < N) {
            int diff = arr[e] - arr[s];
            if (diff < M) e++;
            else {
                ans = Math.min(ans, diff);
                s++;
            }
        }
        System.out.println(ans);
    }
}