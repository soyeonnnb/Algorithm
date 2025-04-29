
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int count = 0;
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++) {
            int result = 0;
            Arrays.fill(visited, false);
            for(int j=0;j<N;j++) {
                if (i == j || visited[j]) continue;
                for(int k=0;k<5;k++) {
                    if (arr[i][k] == arr[j][k]) {
                        visited[j] = true;
                        result++;
                        break;
                    }
                }
            }
            if (count < result) {
                ans = i;
                count =result;
            }
        }
        System.out.println(ans+1);
    }
}
