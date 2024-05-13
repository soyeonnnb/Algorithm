import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = 0;
		int twice = 1;
		while (twice < N) {
			twice *= 2;
			K++;
		}
		int[][] parent = new int[N + 1][K + 1];
		List<int[]>[] arr = new ArrayList[N + 1];
		int[] cost = new int[N + 1];
		int[] depth = new int[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[u].add(new int[] { v, c });
			arr[v].add(new int[] { u, c });
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		depth[1] = 1;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int[] poll : arr[now]) {
				if (depth[poll[0]] != 0)
					continue;
				parent[poll[0]][0] = now;
				cost[poll[0]] = poll[1] + cost[now];
				depth[poll[0]] = depth[now] + 1;
				queue.add(poll[0]);
			}
		}
		
		for(int i=1;i<K;i++) {
			for(int j=1;j<=N;j++) parent[j][i] = parent[parent[j][i-1]][i-1];
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int r = lca(u, v, parent, depth, K);
			int c = cost[u] + cost[v] - 2* cost[r];
			sb.append(c + "\n");
		}
		System.out.println(sb.toString());
	}

	static int lca(int a, int b, int[][] parent, int[] depth, int K) {

		if (depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i = K; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b])
				a = parent[a][i];
		}
		
		if (a == b)
			return a;
		for (int i = K; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];

	}
}