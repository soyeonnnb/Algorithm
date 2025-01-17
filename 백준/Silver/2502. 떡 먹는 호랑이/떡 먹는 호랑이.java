import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D=sc.nextInt();
        int K=sc.nextInt();

        int[][] arr = new int[31][2];
        arr[1][0] = 1;
        arr[2][1] = 1;

        for(int i=3;i<=30;i++) {
            for(int j=0;j<2;j++) arr[i][j] = arr[i-1][j] + arr[i-2][j];
        }

        for(int i=1;i<=100000;i++) {
            if ((K - i * arr[D][0])%arr[D][1] == 0) {
                System.out.println(i);
                System.out.println((K - i * arr[D][0])/arr[D][1]);
                return;
            }
        }

    }
}