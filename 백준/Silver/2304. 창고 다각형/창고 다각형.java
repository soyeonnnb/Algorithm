import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        int[] prefix = new int[1001];
        int[] suffix = new int[1001];
        for(int i=1;i<=1000;i++) prefix[i] = Math.max(prefix[i-1], arr[i]);
        suffix[1000] = arr[1000];
        for(int i=999;i>=1;i--) suffix[i] = Math.max(suffix[i+1], arr[i]);
        int answer = 0;
        int i = 0;
        for(;i<=1000;i++) {
            if (prefix[i] != prefix[1000]) answer += prefix[i];
            else break;
        }
        int j = 1000;
        for(;j>=1;j--) {
            if (suffix[j] != suffix[1]) answer += suffix[j];
            else break;
        }
        answer += prefix[1000] * (j-i+1);
        System.out.println(answer);
    }
}