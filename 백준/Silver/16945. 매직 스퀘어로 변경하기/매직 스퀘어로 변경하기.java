import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] arr, temp;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) arr[i][j] = sc.nextInt();
        }
        temp = new int[3][3];
        visited = new boolean[10];
        answer = 987654321;
        recur(0, 0);
        System.out.println(answer);
    }
    private static boolean check() {
        for(int j=0;j<3;j++) {
            int result = 0;
            for(int i=0;i<3;i++) {
                result += temp[i][j];
            }
            if (result != 15) return false;
        }
        if (temp[0][0] + temp[1][1] + temp[2][2] != 15 || temp[0][2] + temp[1][1] + temp[2][0] != 15) return false;
        return true;
    }
    private static void recur(int x, int y) {
        if (x == 3) {
            if (check()) {
                int result = 0;
                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) result += Math.abs(arr[i][j] - temp[i][j]);
                }
                answer = Math.min(answer, result);
            }
            return;
        }
        if (y == 3) {
            if (temp[x][0] + temp[x][1] + temp[x][2] != 15) return;
            recur(x+1, 0);
            return;
        }

        for(int i=1;i<=9;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[x][y] = i;
            recur(x, y + 1);
            visited[i] = false;
        }
    }
}