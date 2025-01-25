import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) queue.add(i);

        int round = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) break;
            for(int tc=1;tc<=size/2;tc++) {
                int a = queue.poll();
                int b = queue.poll();

                if ((A == a && B == b) || (A == b && B == a)) {
                    System.out.println(round);
                    return;
                }

                if (A == a || A == b) {
                    A = tc;
                } else if (B == a || B == b) {
                    B = tc;
                }
                queue.add(tc);
            }

            if (size %2 == 1) {
                int n = queue.poll();
                queue.add(size/2 + 1);
                if (A == n) {
                    A = size/2 + 1;
                } else if (B == n) {
                    B = size/2 + 1;
                }
            }

            round++;
        }
        System.out.println(-1);
    }
}