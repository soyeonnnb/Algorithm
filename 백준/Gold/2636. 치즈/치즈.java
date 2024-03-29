import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int getTime(int i, int j, int[][] arr, int N, int M) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		int[] first = { i, j, 0 };
		queue.add(first);
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;
		int max = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			max = now[2] + 1;
			for (int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (arr[nx][ny] == 0)
					return now[2] + 1;
				if (!visited[nx][ny]) {
					int[] n = { nx, ny, now[2] + 1 };
					queue.add(n);
					visited[nx][ny] = true;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==1) cheese++;
			}
		}
		boolean[][] visited = new boolean[N][M];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int prev = 0;
		int time =0 ;
		while (cheese != 0) {
			prev = 0;
			for (int i=0;i<N;i++)Arrays.fill(visited[i], false);
			Queue<int[]> queue = new LinkedList<>();
			int[] first = {0, 0};
			visited[0][0]=true;
			queue.add(first);
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				for (int k=0;k<4;k++) {
					int nx = now[0]+dx[k];
					int ny = now[1]+dy[k];
					if (nx<0 || nx >=N || ny < 0 || ny >= M) continue;
					if (arr[nx][ny]==1 && !visited[nx][ny]) { // 치즈인 경우
						prev ++;
						cheese--;
						visited[nx][ny]=true;
						arr[nx][ny]=0;
					} else if (arr[nx][ny]==0 && !visited[nx][ny]) {
						visited[nx][ny]=true;
						int[] temp = {nx, ny};
						queue.add(temp);
					}
				}
			}
			time++;
		}
		System.out.println(time);
		System.out.println(prev);
		

	}
}