
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer>[] list = new List[13];
        for(int i=0;i<=12;i++) list[i] = new ArrayList<>();
        for(int i=0;i<12;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }
        boolean[] visited = new boolean[13];
        outer: for(int i=1;i<=12;i++) {
            if(list[i].size() != 3) continue;
            Arrays.fill(visited, false);
            for(int num : list[i]) {
                int nxt = list[num].size();
                if (nxt > 3||visited[nxt]) continue outer;
                visited[nxt] = true;
            }
            System.out.println(i);
            return;
        }
    }
}
