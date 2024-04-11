import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	static class Node implements Comparable<Node> {
		int to;
		int from;
		int weight;

		public Node(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int findset(int v) {
		if (v == arr[v]) 
			return v;
		else
			return arr[v] = findset(arr[v]);
	}
	
	static boolean union(int t, int f) {
		int t_root = findset(t);
		int f_root = findset(f);
		if (t_root!=f_root) {
			arr[f_root]=t_root;
			return true;
		} else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		arr = new int[V + 1];
		// Make Set
		for (int i = 1; i <= V; i++)
			arr[i] = i;
		List<Node> edges = new ArrayList<>();
		for (int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Node n = new Node(t, f, w);
			edges.add(n);
		}
		edges.sort(null);
		int connected = 0;
		int weight = 0;
		for (int i=0;i<E;i++) {
			Node now = edges.get(i);
			if (union(now.to, now.from)) {
				weight+=now.weight;
//				System.out.println(connected);
				if (++connected == V) break;
			}
		}
		System.out.println(weight);
		
	}
}