import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int max = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i])
				max = arr[i];
		}
		int min = 0;

		long result = -1;
		int height = 0;
		while (min <= max) {
			int mid = (min + max) / 2; // 자를 높이
			long total = 0;
			for (int i = 0; i < N; i++) {
				total += mid > arr[i] ? 0 : arr[i] - mid;
			}
//			System.out.println(mid + " " + total);
			if (total == M) {
				result = total;
				height = mid;
				break;
			} else if (total > M) { // 너무 많이 자름. 하지만 가져갈 수는 있음
				min = mid + 1;
				if (result==-1 || result > total) { // 이미 정해진 답보다는 현명한 답이면
					result = total;
					height = mid;
//					System.out.println("h:   "+height);
				}
			} else { // 너무 조금 자름
				max = mid - 1;
			}
		}
		System.out.println(height);
	}
}
