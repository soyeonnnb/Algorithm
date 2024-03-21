import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] dx = new int[]{-1, 0, 1};

    private static boolean finished;
    private static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) visited[i][j] = str.charAt(j) == '.' ? -1 : 2; // -1은 아직 안간곳, 2는 가도 길이 없는곳
        }
        int answer = 0;
        for(int i=0;i<N;i++) {
            finished = false;
            dfs(i, 0);
            if (finished) answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if (finished) return;
        if (y == M-1) {
            finished = true;
            return;
        }
        for(int i=-1;i<=1;i++) {
            if (x+i < 0 || x+i >= N || visited[x+i][y+1] == 2 || visited[x+i][y+1] == 0) continue;
            visited[x+i][y+1] = 0; // 0 은 파이프라인 설치된 곳
            dfs(x+i, y+1);
            if (finished) return;
            else { // 갔는데 길이 없으면
                visited[x+i][y+1] = 2;
            }
        }
    }
}
