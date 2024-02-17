import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, L, R, X, answer;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        answer=0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        recur(0, 0, 0, 0, 0);
        System.out.println(answer);
    }
    private static void recur(int cur, int sum, int cnt, int min, int max) {
        if (cur == N) {
            if (sum >= L && sum <= R && cnt >= 2 && max-min >= X) answer++;
            return;
        }
        if (sum > R) return;

        recur(cur+1, sum+arr[cur], cnt+1, min == 0 ? arr[cur] : min, arr[cur]);
        recur(cur+1, sum, cnt, min, max);
    }
}