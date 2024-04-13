import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parents;
    private static boolean flag;
    private static List<Integer>[] list;
    private static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        checked = new boolean[N+1];
        Set<Integer>[] setList = new Set[N+1];
        for(int i=0;i<=N;i++) setList[i] = new TreeSet<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            setList[a].add(b);
        }
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            for(int nxt : setList[i]) {
                if (setList[nxt].contains(i)) {
                    list[i].add(nxt);
                } else {
                    checked[nxt] = true;
                }
            }
        }
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        for(int i=1;i<=N;i++) {
            if (checked[i] || parents[i] != i) continue; // 이미 이전에 합쳐진 -> 이미 확인한 그래프
            flag = false;
            dfs(i, i);
            if (!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void dfs(int cur, int prv) {
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            if (checked[nxt]) { // 트리이지만 check 된 노드가 있거나
                flag = true;
            }
            if (!union(cur, nxt)) { // 사이클이 있으면 -> 변호 가능
                flag = true;
                continue;
            }
            dfs(nxt, cur);
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }
    private static boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return false;
        parents[yr] = xr;
        return true;
    }
}