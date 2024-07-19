import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int max = arr[1];
		int[] result = new int[n + 1];
		result[1] = arr[1];
		if (n >= 2) {
			result[2] = arr[1] + arr[2];
			if (max < result[2]) max = result[2];
		}
		if (n >= 3) {
			result[3] = Math.max(arr[1], arr[2])+arr[3];
			if (max < result[3]) max = result[3];
		}
		for (int i = 4; i <= n; i++) {
			result[i] = Math.max(Math.max(result[i - 2], result[i - 3]+arr[i-1]), result[i-4]+arr[i-1])+arr[i];
			if (max < result[i])
				max = result[i];
		}
//		System.out.println(Arrays.toString(result));
		System.out.println(max);
	}
}