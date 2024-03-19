import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tmp = new int[N][2];
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tmp[i][0]=Integer.parseInt(st.nextToken());
			tmp[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tmp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		for (int i=0;i<N;i++) {
			A[i] = tmp[i][1];
			B[i] = tmp[i][1];
		}
		Arrays.sort(A);
		int[][] arr = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if (A[i-1] == B[j-1]) arr[i][j] = arr[i-1][j-1]+1;
				else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		System.out.println(N-arr[N][N]);
	}
}