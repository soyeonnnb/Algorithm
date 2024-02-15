import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] answer;
    private static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        arr = new int[N];
        answer = new int[M];
        sb = new StringBuilder();
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        recur(0);
        System.out.println(sb);

    }
    private static void recur(int cur) {
        if (cur == M) {
            for(int i=0;i<M;i++) sb.append(arr[answer[i]]+" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            answer[cur] = i;
            recur(cur+1);
        }
    }
}