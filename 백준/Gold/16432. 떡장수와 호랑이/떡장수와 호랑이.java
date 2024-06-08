import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Set<Integer>[] set = new Set[N];
        for(int i=0;i<N;i++) set[i] = new HashSet<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++) set[i].add(Integer.parseInt(st.nextToken()));
        }
        int[][] dp = new int[N][10];
        int[][] dpTrack = new int[N][10];
        for(int num : set[0]) dp[0][num] = 1;
        for(int i=1;i<N;i++) {
            for(int num : set[i]){
                for(int before : set[i-1]) {
                    if (before == num) continue;
                    if (dp[i][num] < dp[i-1][before] + 1) {
                        dp[i][num] = dp[i-1][before] + 1;
                        dpTrack[i][num] = before;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int now = 0;
        for(int i=1;i<=9;i++) {
            if (dp[N-1][i] == N) {
                now = i;
                break;
            }
        }
        if (now == 0) {
            System.out.println(-1);
            return;
        }
        sb.append(now);
        int idx = N-1;
        while(idx >= 1) {
            now = dpTrack[idx][now];
            sb.append("\n").append(now);
            idx--;
        }


        System.out.println(sb.reverse());
    }
}