import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] arr;
    private static boolean[][] dominos, visited;
    private static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[8][7];
        for(int i=0;i<8;i++) {
            String str = sc.next();
            for(int j=0;j<7;j++) arr[i][j] = str.charAt(j)-'0';
        }
        dominos = new boolean[7][7];
        visited = new boolean[8][7];

        recur(0, 0);
        System.out.println(answer);

    }

    private static void recur(int x, int y) {
        if (x == 8) {
            answer++;
            return;
        } else if (y == 7) {
            recur(x+1, 0);
            return;
        }
        // 만약 이미 체크가 되어있다면
        if (visited[x][y]) {
            recur(x, y+1);
            return;
        } else {
            // 가로로 넣을 수 있나
            if (y + 1 < 7 && !visited[x][y + 1]) {
                // 아직 도미노를 안놓았다면
                int num1 = arr[x][y];
                int num2 = arr[x][y+1];
                if (num1 > num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                if (!dominos[num1][num2]) {
                    dominos[num1][num2] = true;
                    visited[x][y] = true;
                    visited[x][y+1] = true;
                    recur(x, y+1);
                    dominos[num1][num2] = false;
                    visited[x][y] = false;
                    visited[x][y+1] = false;
                }
            }
            // 세로로 넣을 수 있나
            if (x + 1 < 8 && !visited[x+1][y]) {
                // 아직 도미노를 안놓았다면
                int num1 = arr[x][y];
                int num2 = arr[x+1][y];
                if (num1 > num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                if (!dominos[num1][num2]) {
                    dominos[num1][num2] = true;
                    visited[x][y] = true;
                    visited[x+1][y] = true;
                    recur(x, y+1);
                    dominos[num1][num2] = false;
                    visited[x][y] = false;
                    visited[x+1][y] = false;
                }
            }

        }
    }
}