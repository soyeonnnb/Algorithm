import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb; 
	static boolean[] isVisited;
	
	public static void getNM(int nowIdx, int[] nums) {
		if (nowIdx == M) {
			for (int i=0;i<M;i++) {
				sb.append(arr[nums[i]]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0;i<N;i++) {
			if (isVisited[i])continue;
			nums[nowIdx] = i;
			isVisited[i]=true;
			getNM(nowIdx+1, nums);
			isVisited[i]=false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N=sc.nextInt();
		 M=sc.nextInt();
		 arr = new int[N];
		for (int i=0;i<N;i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		sb = new StringBuilder();
		isVisited = new boolean[N];
		getNM(0,  new int[M]);
		System.out.println(sb.toString());
	}
	
}