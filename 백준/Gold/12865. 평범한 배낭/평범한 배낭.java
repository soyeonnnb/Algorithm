import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][2]; // 무게 - 가치 순
		for (int i=1;i<=N;i++) {
			st= new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] result = new int[N+1][K+1];
		for(int i=1;i<=N;i++) { // 물품
			for (int j=1;j<=K;j++) { // 무게
				if (j<arr[i][0]) result[i][j] = result[i-1][j];
				else {
					if (j-arr[i][0]<0) result[i][j] = result[i-1][j];
					else result[i][j] = Math.max(result[i-1][j], result[i-1][j-arr[i][0]]+arr[i][1]);
				}
			}
		}
		System.out.println(result[N][K]);
	}
}
