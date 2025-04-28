
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        long[] arr = new long[120];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=4;i<=119;i++) {
            arr[i] = arr[i-1] + arr[i-3];
        }
        System.out.println(arr[N]);
    }
}
