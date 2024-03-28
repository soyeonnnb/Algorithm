import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17:21 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        Map<Integer, Set<Integer>> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Set<Integer> set = map.getOrDefault(x, new TreeSet<>());
            set.add(y);
            map.put(x, set);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int ans = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            ans ++;
            for(int s=0;s<sz;s++) {
                int[] now = queue.poll();
                for(int x=-2;x<=2;x++) {
                    Set<Integer> set = map.getOrDefault(now[0]+x, null);
                    if (set == null) continue;
                    for(int y=-2;y<=2;y++) {
                        if (!set.contains(now[1]+y)) continue;
                        set.remove(now[1]+y);
                        queue.add(new int[]{now[0]+x, now[1]+y});
                        if (now[1]+y == T) {
                            System.out.println(ans);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
