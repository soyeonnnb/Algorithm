import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int num = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0;i<N-1;i++) queue.add(sc.nextInt());
        int answer = 0;
        while(!queue.isEmpty() && num <= queue.peek()) {
            num++;
            queue.add(queue.poll() - 1);
            answer++;
        }
        System.out.println(answer);
    }
}
