import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 13:36 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int aNow = map.getOrDefault(a, 0);
            map.put(a, aNow+1);
            int bNow = map.getOrDefault(b, 0);
            map.put(b, bNow-1);
        }
        List<Integer> times = map.keySet().stream().sorted().collect(Collectors.toList());
        int s=0;
        int e=0;
        int ans=0;
        int sum=0;
        boolean flag = false;
        for(Integer t : times) {
            if (map.get(t) == 0) continue;
            sum += map.get(t);

            if (sum > ans) {
                s=t;
                e=t;
                ans=sum;
                flag = true;
            } else if (flag) {
                flag = false;
                e = t;
            }
        }
        System.out.println(ans);
        System.out.println(s+" "+e);
    }
}