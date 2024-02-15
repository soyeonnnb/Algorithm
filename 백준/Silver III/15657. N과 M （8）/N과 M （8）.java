import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int[] result;
	static int[] arr;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		 N = sc.nextInt();
		 M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		perm(0, 0);
		System.out.println(sb);
	}
	static void perm(int nowIdx, int resultIdx) {
		if (resultIdx == M) {
			for (int i=0;i<M;i++) {
				sb.append(arr[result[i]]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=nowIdx;i<N;i++) {
			result[resultIdx] = i;
			perm(i, resultIdx+1);
		}
	} 

}