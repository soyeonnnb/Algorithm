import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new int[N][M];
		// 우선 방문했는지 체크하기 위해 visited 배열을 모두 -1로 둔다
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], -1);
		
		// 최종 목적지에 1을 둔다.
		visited[N-1][M-1] = 1;
		
		dfs(0, 0);
		System.out.println(visited[0][0]);
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y) {
		// 이미 방문한 곳이면 더이상 방문하지 않아도 된다.
		if (visited[x][y]!=-1) return;

		// 지금 방문했다는 표시로 0으로 설정한다.
		visited[x][y] = 0;
		
		// 사방을 확인하면서 각 사방에서의 경로의 합이 현재 내가 갈 수 있는 경로의 개수이다.
		for(int k=0;k<4;k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			// 범위를 초과하거나 내리막길이 아니면 continue
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[x][y] <= arr[nx][ny] ) continue;
			// 더하려고 했는데 방문하지 않은 곳이면 방문한다.
			if (visited[nx][ny] == -1) dfs(nx, ny);
			// 내가 갈 수 있는 경로의 개수 합에 더해준다.
			visited[x][y] += visited[nx][ny];
		}
	}
}