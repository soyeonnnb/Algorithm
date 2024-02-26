import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, answer;
    private static boolean[] arr;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        arr = new boolean[10];
        visited = new int[1500000];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) arr[Integer.parseInt(st.nextToken())] = true;
        }
        answer = Math.abs(N-100); // 현재 있는 곳에서 그냥 화살표만 눌렀을 때
        if (!arr[0]) answer = Math.min(answer, N+1);
        for(int i=1;i<=9;i++) {
            if (!arr[i]) {
                visited[i] = 1;
                recur(i, 1);
            }
        }
        System.out.println(answer);
    }
    private static void recur(int cur, int click) {
        if (cur > 1500000) return;
        if (answer < click) return;
        answer = Math.min(answer, click + Math.abs(N-cur));
        for(int i=0;i<=9;i++) {
            if (arr[i]) continue;
            recur(cur*10+i, click+1);
        }
    }
}