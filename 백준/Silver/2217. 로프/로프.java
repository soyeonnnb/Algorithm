import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr = new int[N];	
		int max = 0 ;
		for (int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if (max<arr[i]) max = arr[i];
		}
		int[] cnt = new int[max+1];
		for (int i=0;i<N;i++) {
			cnt[arr[i]]++;
		}
		
		int answer = 0;
		int total = N;
		for (int i=0;i<=max;i++) {
			if (cnt[i]==0) continue;
			int weight = i*total;
			if (weight>answer) answer = weight;
			total-=cnt[i];
		}
		System.out.println(answer);
	}
}
