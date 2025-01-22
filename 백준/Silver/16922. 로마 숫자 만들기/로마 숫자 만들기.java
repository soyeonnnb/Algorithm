import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int[] arr;
    private static Set<Integer> set;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        set = new HashSet<>();

        recur(0, 0);
        System.out.println(set.size());


    }

    private static void recur(int curIdx, int curNum) {
        if (curIdx == N) {
            int sum = 0;
            for(int i=0;i<N;i++) {
                switch (arr[i]) {
                    case 0 -> sum += 1;
                    case 1 -> sum += 5;
                    case 2 -> sum += 10;
                    case 3 -> sum += 50;
                }
            }
            set.add(sum);
            return;
        }

        if (curNum == 4) return;
        recur(curIdx, curNum + 1);
        arr[curIdx] = curNum;
        recur(curIdx + 1, curNum);
    }
}