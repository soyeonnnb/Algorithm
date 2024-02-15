import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        sb = new StringBuilder();
        visited = new boolean[N+1];
        arr = new int[M];
        recur(0);
        System.out.println(sb);
    }
    private static void recur(int cur) {
        if (cur == M) {
            for(int i=0;i<M;i++) sb.append(arr[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cur] = i;
            recur(cur+1);
            visited[i] = false;
        }
    }
}