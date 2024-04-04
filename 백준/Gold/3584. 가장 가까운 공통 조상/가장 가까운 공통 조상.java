import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] parent = new int[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				parent[B] = A;
			}
			st = new StringTokenizer(br.readLine());
			int findA = Integer.parseInt(st.nextToken());
			int findB = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];
			int idx = findA;
			visited[idx]=true;
			while(idx >= 0 && parent[idx] != idx) {
				visited[idx]=true;
				idx = parent[idx];
			}
			idx = findB;
			while(idx>= 0 && !visited[idx])idx=parent[idx];
			System.out.println(idx);
		}
	}
}