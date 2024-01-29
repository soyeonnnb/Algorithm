import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] brr = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) brr[i] = Integer.parseInt(st.nextToken());
        long answer = 0;
        for(int i=1;i<=N;i++) arr[i] += arr[i-1];
        for(int i=1;i<=M;i++) brr[i] += brr[i-1];
        Map<Integer, Integer> map = new TreeMap<>();
        for(int k=1;k<=M;k++) {
            for(int l=k;l<=M;l++) {
                map.put(brr[l] - brr[k-1], map.getOrDefault(brr[l] - brr[k-1], 0)+1);
            }
        }
        for(int i=1;i<=N;i++) {
            for(int j=i;j<=N;j++) {
                int arrSum = arr[j] - arr[i-1];
                answer += map.getOrDefault(T - arrSum, 0);
            }
        }
        System.out.println(answer);
    }
}