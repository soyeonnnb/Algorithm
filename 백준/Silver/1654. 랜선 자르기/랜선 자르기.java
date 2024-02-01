import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[K];

		long max = 0;
		for (int i = 0; i < K; i++) {
			list[i] = Integer.parseInt(br.readLine());
			if (max < list[i])
				max = list[i];
		}
		long min = 1;
		long maxLength = 1;
		while (min <= max) {
			long middle = (max + min) / 2;
			int num = 0;
			for (int i = 0; i < K; i++) {
				num += list[i] / middle;
			}
			if (num >= N) {
				if (maxLength < middle)
					maxLength = middle;
				min = middle + 1;
			} else {
				max = middle - 1;
			}
		}
		System.out.println(maxLength);
	}
}