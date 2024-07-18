import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16:41 ~
public class Main {
    private static int[][] list;
    private static int now;
    private static int[] width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new int[N+1][2];
        width = new int[N+1];
        boolean[] hasParent = new boolean[N+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            list[n][0] = Integer.parseInt(st.nextToken());
            list[n][1] = Integer.parseInt(st.nextToken());
            if (list[n][0] != -1) hasParent[list[n][0]] = true;
            if (list[n][1] != -1) hasParent[list[n][1]] = true;
        }
        int root = 0;
        for(int i=1;i<=N;i++) if(!hasParent[i]) root = i;
        now = 1;
        dfs(root);
        Queue<Integer> queue = new LinkedList<>();
        int level = 1;
        int ans_w = 1;
        int ans_l = 1;
        queue.add(root);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            int max = 0;
            int min = N+1;
            for(int i=0;i<sz;i++) {
                int now = queue.poll();
                int num = width[now];
                max = Math.max(max, num);
                min = Math.min(min, num);
                if (list[now][0] != -1) queue.add(list[now][0]);
                if (list[now][1] != -1) queue.add(list[now][1]);
            }
            int w = max - min + 1;
            if (w > ans_w) {
                ans_w = w;
                ans_l = level;
            }
            level++;
        }
        System.out.println(ans_l +" "+ ans_w);
    }

    private static void dfs(int cur) {
        if (list[cur][0] != -1) dfs(list[cur][0]);
        width[cur] = now++;
        if (list[cur][1] != -1) dfs(list[cur][1]);
    }
}