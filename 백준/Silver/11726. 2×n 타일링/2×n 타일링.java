import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		arr[1] = 1;
		if (n >= 2)
			arr[2] = 2;
		for (int i = 3; i < n + 1; i++)
			arr[i] = arr[i - 1]%10007 + arr[i - 2]%10007;
		System.out.println(arr[n] % 10007);
	}
}