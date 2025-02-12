import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> num = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (map.containsKey(arr[i])) {
				int value = map.get(arr[i]);
				map.put(arr[i], value + 1);
				num.put(arr[i], value + 1);
			} else {
				map.put(arr[i], 1);
				num.put(arr[i], 1);
			}
		}
		Arrays.sort(arr);

		int answer = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int sum = arr[i] + arr[j];
				if (map.containsKey(sum)) { // 그 수가 있으면
					// 만약 a로 a를 만들었으면
					if (arr[i] == sum || arr[j] == sum) {
						if ((arr[i] == sum && arr[j] != sum) || (arr[i] != sum && arr[j] == sum)) {
							if (num.get(sum) <= 1)
								continue;
						} else if (arr[i] == sum && arr[j] == sum) {
							if (num.get(sum) <= 2)
								continue;
						}
					}

					int value = map.get(sum);
					if (value > 0) {

						answer += value;
						map.put(sum, 0);
					}
				}
			}
		}
		System.out.println(answer);
	}
}