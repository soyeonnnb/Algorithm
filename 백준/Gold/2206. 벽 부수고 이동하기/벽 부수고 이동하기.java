import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0, 1 }); // i좌표, j좌표, 벽 부셨는지 0이면 x, 1이면 부숨
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], -1); // -1이 방문 안한거. 0은 0번 부순거. 1은 1번 부순거
		visited[0][0] = 0;
		int answer = -1;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		outer: while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				// 일단 범위 체크
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (arr[nx][ny] == 0) { // 이동 가능
					// 아직 방문 안했거나 방문 한 곳이면 부수고 갔는데 아직 안부순 경우에만 추가
					if (visited[nx][ny] == -1 || (visited[nx][ny] == 1 && now[2] == 0)) {
						visited[nx][ny] = now[2];
						queue.add(new int[] { nx, ny, now[2], now[3]+1 });
					}

				} else { // 이동 불가
					if (now[2] == 0) { // 아직 한번도 안부순 경우에만 추가
						visited[nx][ny] = 1;
						queue.add(new int[] { nx, ny, 1, now[3]+1 });
					} else
						continue;
				}
				if (nx == N - 1 && ny == M - 1) {
					answer = now[3]+1;
					break outer;
				}
			}
		}
//		for (int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(visited[i]));
		System.out.println(answer);
	}
}