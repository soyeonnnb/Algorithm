import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[N+1][N+1];
		for (int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b]=true;
			arr[b][a]=true;
		}
		boolean[] isGo=new boolean[N+1];
		List<Integer> list = new LinkedList<>();
		list.add(1);
		isGo[1]=true;
		int cnt=0;
		while(list.size()!=0) {
			int now=list.get(0);
			list.remove(0);
			for (int i=1;i<N+1;i++) {
				if (arr[now][i]&&!isGo[i]) {
					list.add(i);
					isGo[i]=true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
	}
}
