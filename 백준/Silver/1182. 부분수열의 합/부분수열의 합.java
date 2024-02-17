import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer =0;
	
	static void getSum(int S, int nowIdx, int nowSum, int[] arr, int num) {
		if (num!=0&&nowSum == S) {
			answer += 1;
		}
		for (int i=nowIdx;i<arr.length;i++) {
			getSum(S, i+1, nowSum+arr[i], arr, num+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		getSum(S, 0, 0, arr, 0);
		System.out.println(answer);
	}
}
