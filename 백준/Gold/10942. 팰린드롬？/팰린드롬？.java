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
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (M > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int result = 1;
			while(s<e) {
				if (arr[s]!=arr[e]) {
					result = 0;
					break;
				} 
				s++;
				e--;
			}
			sb.append(result+"\n");
//			System.out.println(result);
			
			M--;
		}
		System.out.println(sb.toString());
	}
}