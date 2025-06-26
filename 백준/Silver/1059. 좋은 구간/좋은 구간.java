
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[1001];
        for(int i=0;i<N;i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        int n = Integer.parseInt(br.readLine());
        if (visited[n]) {
            System.out.println(0);
            return;
        }
        int rc = 1;
        int lc = 1;
        int l = n-1;
        while(l >= 1 && !visited[l]) {
            lc++;
            l--;
        }
        int r = n + 1;
        while(r <= 1000 && !visited[r]) {
            rc++;
            r++;
        }
        System.out.println(rc * lc - 1);

    }
}
