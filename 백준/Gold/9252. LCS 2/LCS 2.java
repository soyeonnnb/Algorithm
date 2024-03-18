import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] A = sc.next().toCharArray();
		char[] B = sc.next().toCharArray();
		int[][] arr = new int[A.length+1][B.length+1];
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				if (A[i] == B[j]) arr[i+1][j+1]= arr[i][j]+1;
				else arr[i+1][j+1] = Math.max(arr[i][j+1], arr[i+1][j]);
			}
		}
		int num = arr[A.length][B.length];
		System.out.println(num);
		if (num==0) return;
		StringBuilder sb = new StringBuilder();
		int i = A.length-1;
		int j = B.length-1; // B 기준
		while(i >= 0 && j >= 0) {
			if (A[i] == B[j]) {
				sb.append(B[j]);
				i--;
				j--;
			} else {
				if (arr[i][j+1] < arr[i+1][j]) j--;
				else i--;
			}
		}
		System.out.println(sb.reverse().toString());
	}
}