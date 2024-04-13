import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] InsertionSort(int[] arr) {
		for (int i=arr.length-1;i>=1;i--) {
			int maxIdx=0;
			for (int j=1;j<=i;j++) {
				if (arr[maxIdx]<arr[j]) maxIdx=j;
			}
			int temp=arr[maxIdx];
			arr[maxIdx]=arr[i];
			arr[i]=temp;
		}
		return arr;
	}
	static int[] BubbleSort(int[] arr ) {
		for (int i=arr.length-1;i>0;i--) {
			for (int j=0;j<i;j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] result = BubbleSort(arr);
		for (int i:result)System.out.println(i);
	}
}
