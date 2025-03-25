
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static List<int[]> studentList;
    private static char[][] arr;
    private static boolean flag;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new char[N][N];
        studentList = new ArrayList<>();

        for(int i=0;i<N;i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                char c = str[j].charAt(0);
                arr[i][j] = c;
                if (c == 'S') {
                    studentList.add(new int[]{i, j});
                }
            }
        }

        flag = false;

        recur(0, 0, 0);

        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

    private static void recur(int x, int y, int count) {
        if (flag) return;
        else if (y == N) {
            recur(x+1, 0, count);
            return;
        } else if (x == N || count == 3) {
            if (check()) {
                flag = true;
            }
            return;
        }

        // 안놓고 그냥 감
        recur(x, y+1, count);
        if (check(x, y)) {
            arr[x][y] = 'O';
            recur(x, y+1, count+1);
            arr[x][y] = 'X';
        }
    }


    private static boolean check(int x, int y) {
        if (arr[x][y] != 'X') return false;
        for(int[] student : studentList) {
            for(int k=0;k<4;k++) {
                int nx = student[0] + dx[k];
                int ny = student[1] + dy[k];
                while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (nx == x && ny == y) return true;
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        return false;
    }

    private static boolean check() {
        for(int[] student : studentList) {
            outer: for(int k=0;k<4;k++) {
                int nx = student[0] + dx[k];
                int ny = student[1] + dy[k];
                while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == 'O') continue outer;
                    else if (arr[nx][ny] == 'T') return false;
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        return true;
    }
}
