import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] nums;
    private static int[] arr;
    private static boolean[] visited;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        answer = 0;
        recur(0);
        System.out.println(answer);
    }
    private static void recur(int cur) {
        if (cur == N) {
            int sum = 0;
            for(int i=0;i<N-1;i++) {
                sum += Math.abs(arr[nums[i]] - arr[nums[i+1]]);
            }
            answer =  Math.max(answer, sum);
            return;
        }
        for(int i=0;i<N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[cur] = i;
            recur(cur+1);
            visited[i] = false;
        }
    }
}