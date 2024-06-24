import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int s = -1;
        int e = 0;
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        set.add(arr[0]);
        map.put(arr[0], 1);
        while(s < N && e < N) {
            // 한칸 더 늘릴 수 있으면
            ans = Math.max(ans, e-s);
            if (set.size() < 2) {
                e++;
                if (e < N) {
                ans = Math.max(ans, e-s);

                int now = map.getOrDefault(arr[e], 0);
                map.put(arr[e], now+1);
                set.add(arr[e]);
                }
            } else if (e+1 < N && set.contains(arr[e+1])) { // 이미 같은게 끼워져 있으면
                e++;
                int now = map.get(arr[e]);
                map.put(arr[e], now+1);
                ans = Math.max(ans, e-s);
            } else { // 못늘리면 걍 줄임
                s++;
                int now = map.get(arr[s]);
                now--;
                if (now == 0) {
                    set.remove(arr[s]);
                }
                map.put(arr[s], now);
            }
        }
        System.out.println(ans);
    }
}
