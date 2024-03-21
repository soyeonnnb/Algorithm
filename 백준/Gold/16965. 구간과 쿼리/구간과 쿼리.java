import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12:35 ~
// DFS로 하자 !
public class Main {
    private static boolean[] visited;
    private static boolean isFinished;
    private static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>();
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (order == 1) list.add(new int[]{x, y});
            else if (order == 2) {
                visited = new boolean[list.size()];
                isFinished = false;
                visited[x-1] = true;
                dfs(x-1, y-1);
                System.out.println(isFinished ? 1 : 0);
            }
        }
    }
    private static void dfs(int now, int dest) {
        visited[now] = true;
        if (isFinished) return;
        if (now == dest) {
            isFinished = true;
            return;
        }
        for(int i=0;i<list.size();i++) {
            if (visited[i]) continue;
            if ((list.get(i)[0] <list.get(now)[0] && list.get(now)[0] < list.get(i)[1]) || (list.get(i)[0] < list.get(now)[1] && list.get(now)[1] < list.get(i)[1] )) dfs(i, dest);
            if (isFinished) return;
        }
    }
}