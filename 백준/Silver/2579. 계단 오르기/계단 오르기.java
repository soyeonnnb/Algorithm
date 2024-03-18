import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int[] score = new int[N + 1];
		score[1] = arr[1];
		if (N >= 2)
			score[2] = arr[1] + arr[2];
		if (N >= 3)
			score[3] = Math.max(arr[1], arr[2]) + arr[3];
		for (int i = 4; i <= N; i++)
			score[i] = Math.max(score[i - 2], score[i - 3] + arr[i - 1]) + arr[i];

		System.out.println(score[N]);
	}
}