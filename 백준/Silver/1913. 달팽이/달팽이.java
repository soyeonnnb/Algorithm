import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int search = sc.nextInt();
        int[][] arr = new int[N][N];
        int[] xy = new int[2];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int num = N*N;
        int x = 0;
        int y = 0;
        int dire = 0;
        while(num>0) {
            arr[x][y] = num;
            if (num == search) {
                xy[0] = x+1;
                xy[1] = y+1;
            }
            if (x + dx[dire] < 0 || x + dx[dire] >= N || y + dy[dire] < 0 || y + dy[dire] >= N || arr[x + dx[dire]][y + dy[dire]] != 0) dire = (dire + 1)%4;
            num--;
            x += dx[dire];
            y += dy[dire];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) sb.append(arr[i][j]+" ");
            sb.append("\n");
        }
        sb.append(xy[0]+" "+xy[1]);
        System.out.println(sb);
    }
}