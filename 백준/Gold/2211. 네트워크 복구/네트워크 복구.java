import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int end, w;

		public Edge(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}
		
	}
	static final int INF =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		List<Edge>[] arr = new ArrayList[N+1];
		for (int i=0;i<=N;i++) arr[i] = new ArrayList<>();
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[start].add(new Edge(end, weight));
			arr[end].add(new Edge(start, weight));
		}
		int[] result = new int[N+1];
		Arrays.fill(result, INF);
		int[] parent = new int[N+1];
		boolean[] visited = new boolean[N+1];
		parent[1]=1;
		result[1]=0;
		int connected = 0;
		while(connected != N-1) {
			int idx = -1;
			int min = INF;
			for (int i=1;i<=N;i++) {
				if (!visited[i] && result[i]<min) {
					idx = i;
					min = result[i];
				}
			}
			if (idx == -1)break;
			visited[idx] = true;
			for (Edge e : arr[idx]) {
				if (visited[e.end]) continue;
				if (result[e.end] > result[idx] + e.w) {
					result[e.end] = result[idx] + e.w;
					parent[e.end] = idx;
				}
			}
			connected++;
		}
		System.out.println(connected);
		Arrays.fill(visited, false);
		for(int i=2;i<=N;i++) {
			if (!visited[i]) {
				System.out.println(i+" "+parent[i]);
				visited[i]=true;
			}
		}
	
		
//		System.out.println(Arrays.toString(parent));
		
	}
}