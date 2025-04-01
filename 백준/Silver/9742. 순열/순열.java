
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int count;
    private static boolean[] visited;
    private static char[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            StringBuilder sb = new StringBuilder();
            char[] str = sc.next().toCharArray();
            int N=sc.nextInt();
            ans = new char[str.length];
            visited = new boolean[str.length];
            count = 0;
            recur(str, N, 0);
            sb.append(str).append(" ").append(N).append(" = ");
            if (count < N) {
                sb.append("No permutation");
            } else {
                sb.append(ans);
            }
            System.out.println(sb);
        }
    }
    private static void recur(char[] str, int N, int idx) {
        if (count == N) {
            return;
        }
        if (idx == str.length) {
            count++;
            return;
        }
        for(int i=0;i<str.length;i++) {
            if (visited[i]) continue;
            ans[idx] = str[i];
            visited[i] = true;
            recur(str, N, idx+1);
            visited[i] = false;
            if (count == N) return;
        }

    }
}
