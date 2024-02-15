import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static char[] arr;
    private static boolean[] visited;
    private static int[] answer;
    private static boolean fin;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       N=sc.nextInt();
       arr = new char[N];
       for(int i=0;i<N;i++) arr[i] = sc.next().charAt(0);
       visited = new boolean[10];
       answer = new int[N+1];
       fin=false;
       recur(0, false);
       Arrays.fill(visited, false);
       Arrays.fill(answer, 0);
       fin=false;
       recur(0, true);
    }


    private static void recur(int cur, boolean startMin) {
        if (fin) return;
        if (cur >= 2) {
            if (arr[cur-2] == '<' && answer[cur-2] > answer[cur-1]) return;
            if (arr[cur-2] == '>' && answer[cur-2] < answer[cur-1]) return;
        }
        if (cur == N+1) {
            System.out.println(toStr());
            fin=true;
            return;
        }
        if (startMin) {
            for(int i=0;i<=9;i++) {
                if (visited[i]) continue;
                visited[i] = true;
                answer[cur] = i;
                recur(cur+1, startMin);
                visited[i] = false;
            }
        } else {
            for(int i=9;i>=0;i--) {
                if (visited[i]) continue;
                visited[i] = true;
                answer[cur] = i;
                recur(cur+1, startMin);
                visited[i] = false;
            }
        }

    }
    private static String toStr() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=N;i++) sb.append(answer[i]);
        return sb.toString();
    }
}