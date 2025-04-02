import java.util.Scanner;

public class Main {
    private static int N, min, max;
    private static int[] arr, operator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        operator = new int[4];
        for(int i=0;i<4;i++) operator[i] = sc.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        recur(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    private static void recur(int idx, int num) {
        if (idx == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        for(int i=0;i<4;i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            recur(idx+1, makeNum(num, arr[idx], i));
            operator[i]++;
        }
    }

    private static int makeNum(int num, int nxtNum, int oper) {
        if (oper == 0) {
            return num + nxtNum;
        } else if (oper == 1) {
            return num - nxtNum;
        } else if (oper == 2) {
            return num * nxtNum;
        } else {
            return num/nxtNum;
        }
    }
}
