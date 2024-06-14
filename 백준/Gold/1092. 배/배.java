import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] crane = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) crane[i][0] = Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(br.readLine());
        int[] arr = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(crane, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(arr);
        if (crane[N-1][0] < arr[M]) {
            System.out.println(-1);
            return;
        }
        int idx = M;
        int cIdx = N-1;
        boolean[] visited = new boolean[M+1];
        int count = 0;
        while(idx>=1 && cIdx>=0) {
            if (crane[cIdx][0] >= arr[idx]) {
                visited[idx]=true;
                crane[cIdx--][1] = idx--;
                count++;
            } else {
                idx--;
            }
        }
        int time = 1;
        while(count < M) {
            time++;
            for(int c=N-1;c>=0;c--) {
                if (crane[c][1] == 0) continue;
                idx = crane[c][1]-1;
                while(idx >= 1 && visited[idx]) idx--;
                if (idx != 0) {
                    visited[idx] = true;
                    crane[c][1] = idx;
                    count++;
                }
            }
        }
        System.out.println(time);

    }
}