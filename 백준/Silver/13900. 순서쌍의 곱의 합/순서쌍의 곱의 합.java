import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        long sum = 0;
        for(int i=0;i<N;i++) sum += arr[i];
        long ans = 0;
        for(int i=0;i<N;i++) ans += arr[i] * (sum - arr[i]);
        System.out.println(ans/2);
    }
}