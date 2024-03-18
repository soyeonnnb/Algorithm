import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		int[] result = new int[N];
		result[0]=1;
		for (int i=1;i<N;i++) {
			for (int j=i-1;j>=0;j--) {
				if (arr[i]>arr[j])
					result[i] = Math.max(result[j]+1, result[i]);
			}
			if (result[i]==0) result[i]=1;
		}
		int answer = 0;
		for (int i=0;i<N;i++) answer = Math.max(answer, result[i]);
		System.out.println(answer);
		
	}
}