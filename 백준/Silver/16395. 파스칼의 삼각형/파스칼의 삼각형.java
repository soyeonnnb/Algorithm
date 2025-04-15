import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int[][] arr = new int[N][K];
        for(int i=0;i<N;i++) {
            for(int j=0;j<K;j++) {
                if (i == 0 || j == 0) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        System.out.println(arr[N-K][K-1]);
    }
}
