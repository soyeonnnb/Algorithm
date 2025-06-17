import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int num = sc.nextInt();
        if (num > N*M) {
            System.out.println(0);
            return;
        }
        int[][] arr = new int[N+2][M+2];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int k = 0;
        int x = 1;
        int y = 1;
        int now=1;
        for(int i=0;i<=N+1;i++) {
            for(int j=0;j<=M+1;j++) {
                if (i == 0 || i == N+1 || j == 0 || j == M+1) arr[i][j] = -1;
            }
        }
        arr[1][1] = 1;
        while(now < N * M) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (arr[nx][ny] != 0) {
                k = (k+1)%4;
                nx = x + dx[k];
                ny = y + dy[k];
            }
            arr[nx][ny] = ++now;
            x = nx;
            y = ny;
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if (arr[i][j] == num) {
                    System.out.println(j+" "+i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
