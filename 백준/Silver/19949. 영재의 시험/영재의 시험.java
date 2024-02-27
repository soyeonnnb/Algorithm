import java.util.Scanner;

public class Main {
    private static int answer;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[10];
        for(int i=0;i<10;i++) arr[i] = sc.nextInt();
        answer = 0;
        recur(0, 0, 0, 0);
        System.out.println(answer);
    }
    private static void recur(int cur, int result, int ans, int count) {
        if (cur == 10) {
            if (result >= 5) answer++;
            return;
        }
        for(int i=1;i<=5;i++) {
            if (ans == i && count == 2) continue;
            recur(cur+1, result + (arr[cur] == i ? 1 : 0), i, (ans == i ? count+1 : 1));
        }
    }

}