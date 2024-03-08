import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[][][][] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answer = new int[N+1][3][5][2];
        for(int i=0;i<=N;i++) for(int j=0;j<3;j++) for(int k=0;k<5;k++) Arrays.fill(answer[i][j][k], -1);
        System.out.println(recur(2, 0, 0, 0));
    }

    public static int recur(int cur, int num, int height, int two) { // 현재 몇번째, 지금까지 몇개 뛰어넘었는지, 뛰어 넘은 선인장 높이
        if (height >= 4 || num > 2) return 0; // 두 선인장 높이의 합이 4 이상이면 안됨
        if (cur == N+1) {
            if (two == 1) return 1;
            else return 0;
        }

        if (answer[cur][num][height][two] != -1) return answer[cur][num][height][two];
        answer[cur][num][height][two] = (recur(cur+1, 0, 0, two) + recur(cur+1, num+1, height+1, two))%1000000007 + recur(cur+1, num+1, height+2, 1);
        answer[cur][num][height][two] %= 1000000007;
        return answer[cur][num][height][two];
    }
}