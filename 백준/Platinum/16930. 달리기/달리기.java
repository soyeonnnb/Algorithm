import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], -1);
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1 });
		visited[x1][y1] = 0;
		outer: while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			for (int k = 0; k < 4; k++) {
				for (int l = 1; l <= K; l++) {
					int nx = x + dx[k] * l;
					int ny = y + dy[k] * l;
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == '#')
						break;
					if (visited[nx][ny]!=-1 && visited[nx][ny]<visited[x][y]+1)
						break;
					if (visited[nx][ny] == visited[x][y]+1) continue;
					visited[nx][ny] = visited[x][y] + 1;
					if (nx == x2 && ny == y2)
						break outer;
					queue.add(new int[] { nx, ny });
				}

			}
		}
		

		System.out.println(visited[x2][y2]);
	}

}