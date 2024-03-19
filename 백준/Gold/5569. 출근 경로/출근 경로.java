import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][][][] arr = new int[w+1][h+1][2][2]; // w, h, 현재방향, 방향 바꿧는지(0 -> 안바꿈, 1 -> 바꿈)
        for(int i=1;i<=h;i++) arr[1][i][1][0] = 1;
        for(int i=1;i<=w;i++) arr[i][1][0][0] = 1;
        for(int i=2;i<=w;i++) {
            for(int j=2;j<=h;j++) {
                arr[i][j][0][0] = (arr[i-1][j][0][0] + arr[i-1][j][0][1])%100000;
                arr[i][j][0][1] = arr[i-1][j][1][0];
                arr[i][j][1][0] = (arr[i][j-1][1][0] + arr[i][j-1][1][1])%100000;
                arr[i][j][1][1] = arr[i][j-1][0][0];
            }
        }
        int ans = 0;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) ans += arr[w][h][i][j];
        System.out.println(ans%100000);
    }
}