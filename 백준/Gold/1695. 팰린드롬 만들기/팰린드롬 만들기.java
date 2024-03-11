import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) Arrays.fill(result[i], -1);
        System.out.println(recur(0, N-1));
    }
    private static int recur(int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (result[s][e] != -1) return result[s][e];
        if (s >= N || e < 0) return 987654321;
        if (arr[s] == arr[e]) result[s][e] = recur(s+1, e-1);
        else {
            result[s][e] = Math.min(recur(s+1, e), recur(s, e-1))+1;
        }
        return result[s][e];
    }
}