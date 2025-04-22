
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for(int i=0;i<5;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        set = new HashSet<>();
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                recur(i, j, 1, arr[i][j]);
            }
        }
        System.out.println(set.size());
    }
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static void recur(int x, int y, int count, int number) {
        if (count == 6) {
            set.add(number);
            return;
        }
        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            recur(nx, ny, count+1, number * 10 + arr[nx][ny]);
        }
    }
}
