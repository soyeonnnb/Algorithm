import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int W;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 H = Integer.parseInt(st.nextToken());
		 W = Integer.parseInt(st.nextToken());
		 arr = new int[W];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int max_idx = 0;
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
				max_idx = i;
			}
		}
		int answer =0;
		int left_max = max_idx;
		while(left_max > 0) {
			int idx = getMax(0, left_max - 1);
			
			for(int i=idx+1;i<left_max;i++) {
				answer += arr[idx]-arr[i];
			}
			
			if (idx == 0) {
				break;
			}
			left_max = idx;
		}
		int right_max = max_idx;
		while(right_max < W) {
			int idx = getMax(right_max+1, W-1);
			
			for(int i=right_max+1;i<idx;i++) {
				answer += arr[idx]-arr[i];
			}
			
			if (idx == W-1) {
				break;
			}
			right_max = idx;
		}
		System.out.println(answer);
		
	}
	static int getMax(int left, int right) {
		int result_idx = left;
		for(int i = left;i<=right;i++) {
			if (arr[result_idx]<arr[i]) {
				result_idx = i;
			}
		}
		return result_idx;
	}
}