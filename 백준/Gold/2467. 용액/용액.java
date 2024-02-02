import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int min = Math.abs(arr[0] + arr[N - 1]);
		int answer_i = 0;
		int answer_j = N - 1;
		int i = 0;
		int j = N-1;
		while( i < j ) {
			int tmp = arr[i]+arr[j];
			if (Math.abs(tmp) < min) {
				min = Math.abs(tmp);
				answer_i = i;
				answer_j = j;
			}
			if (tmp < 0) i++;
			else j--;
		}
//		for (int i = 0; i < N - 1; i++) {
//			int j = binary(i, i + 1, N - 1, arr);
//			int sum = Math.abs(arr[i] + arr[j]);
//			if (sum < min) {
//				min = sum;
//				answer_i = i;
//				answer_j = j;
//			}
//		}
		System.out.println(arr[answer_i] + " " + arr[answer_j]);
	}

//	static int binary(int index, int start, int end, int[] arr) {
//		int ab = Math.abs(arr[index] + arr[end]);
//		while (start <= end) {
//			int mid = (start + end) / 2;
//			int tmp = arr[index] + arr[mid];
//			if (tmp < 0) {
//				if (Math.abs(tmp) < ab) {
//					start = mid+1;
//				} else {
//					end = mid-1;
//				}
//			} else if (tmp == 0) {
//				return mid;
//			} else {
//				if (Math.abs(tmp) < ab) {
//					end = mid-1;
//				} else {
//					start = mid+1;
//				}
//			}
//		}
//		return start;
//	}
}