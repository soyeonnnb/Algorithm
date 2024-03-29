import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		if (K == N) {
			System.out.println(0);
			return;
		}
		 
		Queue<int[]> queue = new LinkedList<>();
		int[] first = {N, 0};
		queue.add(first);
		visited[N]=true;
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			int num = now[0];
			if (num-1>=0&&!visited[num-1]) {
				if (num-1==K) {
					System.out.println(now[1]+1);
					break;
				}
				int[] temp = {num-1, now[1]+1};
				queue.add(temp);
				visited[num-1]=true;
			}
			if (num+1<=100000&&!visited[num+1]){
				if (num+1==K) {
					System.out.println(now[1]+1);
					break;
				}
				int[] temp = {num+1, now[1]+1};
				queue.add(temp);
				visited[num+1]=true;
			}
			if (num*2<=100000&&!visited[num*2]){
				if (num*2==K) {
					System.out.println(now[1]+1);
					break;
				}
				int[] temp = {num*2, now[1]+1};
				queue.add(temp);
				visited[num*2]=true;
			}
		}
	}
}