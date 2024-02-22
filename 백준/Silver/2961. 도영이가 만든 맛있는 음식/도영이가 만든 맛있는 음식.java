import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Food {
		int sour, bitter;

		public Food(int sour, int bitter) {
			super();
			this.sour = sour;
			this.bitter = bitter;
		}

	}

	static int N;
	static Food[] arr;
	static int answer;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Food[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Food(s, b);
		}
	 answer = INF;

		back(0, 1, 0, false); // 현재 idx, sour, bitter, 사용했는지

		System.out.println(answer);
	}

	static void back(int idx, int s, int b, boolean use) {
		if (idx == N) {
			if (use)
				answer = Math.min(answer, Math.abs(s - b));
			return;
		}
		back(idx + 1, s, b, use);
		back(idx + 1, s * arr[idx].sour, b + arr[idx].bitter, true);
	}
}