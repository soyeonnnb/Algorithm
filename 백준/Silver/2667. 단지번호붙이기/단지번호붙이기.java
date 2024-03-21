import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) arr[i][j] = str.charAt(j) - '0' == 1;
        }
        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if (!arr[i][j] || visited[i][j]) continue;
                count = 0;
                dfs(i, j, arr, visited);
                answer.add(count);
            }
        }
        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for(int n : answer) System.out.println(n);
    }
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static void dfs(int x, int y, boolean[][] arr, boolean[][] visited) {
        visited[x][y] = true;
        count++;
        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length || !arr[nx][ny] || visited[nx][ny]) continue;
            dfs(nx, ny, arr, visited);
        }

    }
}