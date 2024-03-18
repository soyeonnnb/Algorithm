import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int[][] arr = new int[str1.length()+1][str2.length()+1];
		for (int i=0;i<str1.length();i++) {
			for (int j=0;j<str2.length();j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					arr[i+1][j+1] = arr[i][j]+1;
				} else {
					arr[i+1][j+1] = Math.max(arr[i+1][j], arr[i][j+1]);
				}
			}
		}
		System.out.println(arr[str1.length()][str2.length()]);
	}
}
