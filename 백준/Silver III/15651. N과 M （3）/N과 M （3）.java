import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static void getNM(int N, int M, int[]result, int nowIdx) throws IOException {
		if (M==nowIdx) {
			for (int i:result)sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for (int i=1;i<=N;i++) {
			result[nowIdx]=i;
			getNM(N, M, result, nowIdx+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] result=new int[M];
		getNM(N, M, result, 0);
		System.out.println(sb);
	}
}
