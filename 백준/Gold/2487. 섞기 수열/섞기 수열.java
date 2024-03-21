import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 23:31 ~
public class Main {
    private static int[] arr;
    private static int count;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N+1];
        Set<Integer> set = new TreeSet<>();
        int lcm = 0;
        for(int i=1;i<=N;i++) {
            if (!visited[i]) {
                count = 1;
                dfs(i, 1);
                if (count!=1) {
                    set.add(count);
                    lcm = count;
                }
            }
        }
        for(int x : set) {
            lcm = lcm(lcm, x);
        }
        System.out.println(lcm);
    }
    private static int gcd(int x, int y) {
        if(x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        while(y != 0) {
            int temp = x%y;
            x = y;
            y = temp;
        }
        return x;
    }
    private static int lcm(int x, int y) {
        int gcd = gcd(x, y);
        return (x/gcd) * (y/gcd) * gcd;
    }
    private static void dfs(int x, int cnt) {
        visited[x] = true;
        if (!visited[arr[x]]) {
            count++;
            dfs(arr[x], cnt+1);
        }
    }
}