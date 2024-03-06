import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = i; // 시작시간
			arr[i][1] = Integer.parseInt(st.nextToken()) + i-1; // 끝나는 시간
			arr[i][2] = Integer.parseInt(st.nextToken()); // 이익
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1];
				else if (o1[2] != o1[2])
					return o2[2] - o1[2];
				else
					return o1[0] - o2[0];
			}

		});
		int[] opt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (arr[i][1] > N) {
				opt[i] = opt[i - 1];
				continue;
			}
			int k = i;
			for (int j = i - 1; j >= 1; j--) {
				if (arr[j][1] < arr[i][0]) {
					k = j;
					break;
				}
			}
			opt[i] = Math.max(opt[i-1], opt[k] + arr[i][2]);
		}
		System.out.println(opt[N]);
	}
}