
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N*2;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int ans = arr[N*2-1] * 2;
        for(int i=0;i<N;i++) {
            ans = Math.min(ans, arr[i] + arr[N*2-i-1]);
        }
        System.out.println(ans);
    }
}
