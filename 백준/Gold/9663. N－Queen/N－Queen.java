import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    private static int N, answer;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        answer = 0;
        recur(0);
        System.out.println(answer);
    }
    private static void recur(int cur) {
        if (cur > 1) {
            for(int i=0;i<cur-1;i++) {
                if (Math.abs(arr[i] - arr[cur-1]) == Math.abs(i-(cur-1))) return;
            }
        }
        if (cur == N) {
            answer ++;
            return;
        }
        for(int i=0;i<N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cur] = i;
            recur(cur+1);
            visited[i] = false;
        }

    }
}