import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[] result = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		result[N]=1;
		// 초기값 넣어주기. 여기 넣어지는 것들은 0초에 가는거.
		if (N!=0)
		for(int i=N*2;i<=100000;i*=2) {
			result[i]=1;
			queue.add(i);	
		}
		outer: while(!queue.isEmpty()) {
			int now = queue.poll();
			int day = result[now]+1;
			// 1초 후에 가는 것
			// X + 1
			if (now+1 <= 100000 && result[now+1]==0) {
				result[now+1]  = day;
				queue.add(now+1);
				if(now+1 == K) break;
				for (int i=(now+1)*2;i<=100000;i*=2) {
					if (result[i]!=0) break;
					result[i] = day;
					queue.add(i);
					if (i == K) break outer;
				}
			}
			// X - 1
			if (now-1 >= 0 && result[now-1]==0) {
				result[now-1]  = day;
				queue.add(now-1);
				if(now-1 == K) break;
				if (now-1 != 0 )
				for (int i=(now-1)*2;i<=100000;i*=2) {
					if (result[i]!=0) break;
					result[i] = day;
					queue.add(i);
					if (i == K) break outer;
				}
			}
		}
		System.out.println(result[K]-1);
		
	}
}