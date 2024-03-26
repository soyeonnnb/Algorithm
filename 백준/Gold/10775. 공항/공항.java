import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 13:12 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G=Integer.parseInt(br.readLine());
        int P=Integer.parseInt(br.readLine());
        parents =new int[G+1];
        for(int i=1;i<=G;i++) parents[i] = i;
        int ans = 0;
        boolean[] visited = new boolean[G+1];
        for(int i=0;i<P;i++) {
            int now = Integer.parseInt(br.readLine());
            if (!visited[now]) { // 아직 도킹안한 게이트라면
                visited[now] = true;
                parents[now]--; // 이 앞 게이트를 바라보도록 한다.
            } else {
                int todo = findset(now);
                if (todo == 0) break;
                visited[todo] = true;
                parents[todo]--;
            }
            ans++;
        }
        System.out.println(ans);
    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }
}