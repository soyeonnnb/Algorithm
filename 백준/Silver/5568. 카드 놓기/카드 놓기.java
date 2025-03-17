
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static int N, K;
    private static int[] arr;
    private static boolean[] checked;
    private static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        set = new TreeSet<>();
        checked = new boolean[N];
        recur(0, 0);
        System.out.println(set.size());
    }
    private static void recur(int now, int num) {
        if (now == K) {
            set.add(num);
            return;
        }
        for(int i=0;i<N;i++) {
            if (checked[i]) continue;
            checked[i] = true;
            recur(now+1, makeNumber(num, arr[i]));
            checked[i] = false;
        }
    }

    private static int makeNumber(int num, int appendNum) {
        if (num == 0) return appendNum;
        else if (appendNum < 10) return num * 10 + appendNum;
        else return num * 100 + appendNum;
    }
}
