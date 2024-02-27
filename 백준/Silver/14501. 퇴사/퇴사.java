import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [][] arr = new int[N+1][3];
		for (int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ti = Integer.parseInt(st.nextToken());
			int pi = Integer.parseInt(st.nextToken());
			int[] temp = {i, i+ti-1, pi};
			arr[i]=temp;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] ol, int[] o2) {
				return ol[1]-o2[1];
			}
		});
//		for(int i=1;i<=N;i++) System.out.println(Arrays.toString(arr[i]));
		int[] result = new int[N+1];
//		for (int i=1;i<=N;i++) {
//			if(arr[i][1]>N) break;
////			if (arr[i][1])
//		}
		if (arr[1][1]>N) {
			System.out.println(0);
			return;
		}
		result[1] = arr[1][2]; 
		for (int i=2;i<=N;i++) {
			if (arr[i][1]>N) {result[i] = result[i-1];continue;}
			int idx =0;
			for (int j=i-1;j>=1;j--) {
				if (arr[j][1]<arr[i][0]) {
					idx = j;
					break;
				}
			}
			result[i] = result[i-1]>result[idx]+arr[i][2]?result[i-1]:result[idx]+arr[i][2];
		}
//		System.out.println(Arrays.toString(result));
		System.out.println(result[N]);
	}
}