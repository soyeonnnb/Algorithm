import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static void getNM(int N, int M, int[] result, int nowIdx, int num) {
		if (M == nowIdx) {
			for (int i:result)sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for (int i=num;i<=N;i++) {
			result[nowIdx]=i;
			getNM(N, M, result, nowIdx+1, i);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] result = new int[M];
		getNM(N, M, result, 0,1);
		System.out.println(sb);
	}
}
