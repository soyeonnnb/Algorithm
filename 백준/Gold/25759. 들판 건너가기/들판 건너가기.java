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
        int[] dp = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put(arr[0], 0);
        set.add(arr[0]);
        for(int i=1;i<N;i++) {
            for(Integer key : set) {
                dp[i] = Math.max(dp[i], dp[map.get(key)] + (arr[i] - key) * (arr[i] - key));
            }
            set.add(arr[i]);
            map.put(arr[i], i);
        }
        System.out.println(dp[N-1]);
    }
}