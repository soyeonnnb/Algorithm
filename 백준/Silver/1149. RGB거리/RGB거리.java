import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] result = new int[2][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			result[1][0] = Math.min(result[0][1], result[0][2]) + first;
			result[1][1] = Math.min(result[0][0], result[0][2]) + second;
			result[1][2] = Math.min(result[0][0], result[0][1]) + third;
			result[0][0] = result[1][0];
			result[0][1] = result[1][1];
			result[0][2] = result[1][2];
		}
//		System.out.println(Arrays.toString(result[0]));
		int min = Math.min(Math.min(result[0][0], result[0][1]), result[0][2]);
		System.out.println(min);

	}
}