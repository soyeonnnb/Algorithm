import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int X;
	static ArrayList<Edge>[] arr;
	static final int INF = Integer.MAX_VALUE;

	static class Edge {
		int end, w;

		public Edge(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[start].add(new Edge(end, weight));
		}
		int[] go = new int[N+1];
		for (int i=1;i<=N;i++) {
			if (i == X) go[i]=0;
			else go[i] = dijsktraOne(i, X);
		}
		int[] back = dijstra(X);
		int answer = 0;
//		System.out.println(Arrays.toString(go));
//		System.out.println(Arrays.toString(back));
		for (int i=1;i<=N;i++) answer = Math.max(answer, go[i]+back[i]);
		System.out.println(answer);
	}
	static int[] dijstra(int start) {
		int[] result = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(result, INF);
		result[start] = 0;
		int connected = 0;
		while (connected != N - 1) {
			int idx = -1;
			int min = INF;
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > result[i]) {
					idx = i;
					min = result[i];
				}
			}
			if (idx == -1)
				break;
			visited[idx] = true;
			for (Edge e : arr[idx]) {
				if (visited[e.end])
					continue;
				result[e.end] = Math.min(result[e.end], result[idx] + e.w);
			}
			connected++;
		}
		return result;
	}

	static int dijsktraOne(int start, int end) {
		int[] result = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(result, INF);
		result[start] = 0;
		int connected = 0;
		while (connected != N - 1) {
			int idx = -1;
			int min = INF;
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > result[i]) {
					idx = i;
					min = result[i];
				}
			}
			if (idx == -1)
				break;
			visited[idx] = true;
			if (idx == end)
				return result[idx];
			for (Edge e : arr[idx]) {
				if (visited[e.end])
					continue;
				result[e.end] = Math.min(result[e.end], result[idx] + e.w);
			}
			connected++;
		}
		return result[end];
	}
}