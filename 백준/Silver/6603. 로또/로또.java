import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] answer;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            if (N == 0) break;
            arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            answer = new int[6];
            recur(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recur(int cur, int index) {
        if (cur == 6) {
            for(int i=0;i<6;i++) sb.append(arr[answer[i]]+" ");
            sb.append("\n");
            return;
        } else if (cur == N) return;
        for(int i=index;i<N;i++) {
            answer[cur] = i;
            recur(cur+1, i+1);
        }
    }
}