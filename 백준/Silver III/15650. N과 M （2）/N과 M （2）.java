import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        arr = new int[M];
        sb = new StringBuilder();
        recur(0, 1);
        System.out.println(sb);
    }
    private static void recur(int cur, int num) {
        if (cur == M) {
            for(int i=0;i<M;i++) sb.append(arr[i]+" ");
            sb.append("\n");
            return;
        }
        for(int i=num;i<=N;i++) {
            arr[cur] = i;
            recur(cur+1, i+1);
        }
    }
}