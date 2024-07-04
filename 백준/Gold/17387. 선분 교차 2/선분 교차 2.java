import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][][] arr = new long[2][2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) for(int k=0;k<2;k++) arr[i][j][k] = sc.nextLong();
        int p1p2 = getccw(arr[0], arr[1]);
        int p3p4 = getccw(arr[1], arr[0]);

        if (p1p2 == 0 && p3p4 == 0) { // 일직선임.
            if (Math.max(arr[0][0][0], arr[0][1][0]) < Math.min(arr[1][0][0], arr[1][1][0])) System.out.println(0);
            else if (Math.max(arr[1][0][0], arr[1][1][0]) < Math.min(arr[0][0][0], arr[0][1][0])) System.out.println(0);
            else if (Math.max(arr[0][0][1], arr[0][1][1]) < Math.min(arr[1][0][1], arr[1][1][1])) System.out.println(0);
            else if (Math.max(arr[1][0][1], arr[1][1][1]) < Math.min(arr[0][0][1], arr[0][1][1])) System.out.println(0);
            else System.out.println(1);
        } else if (p1p2 <= 0 && p3p4 <= 0) System.out.println(1);
        else System.out.println(0);

    }

    private static int getccw(long[][] arr1, long[][] arr2) {
        return ccw(arr1[0], arr1[1], arr2[0]) * ccw(arr1[0], arr1[1], arr2[1]);
    }
    private static int ccw(long[] arr1, long[] arr2, long[] arr3) {
        long s =arr1[0]*arr2[1] + arr2[0] * arr3[1] + arr3[0] * arr1[1];
        s -= (arr1[1] * arr2[0] + arr2[1] * arr3[0] + arr3[1] * arr1[0]);
        if (s < 0) return -1;
        else if (s == 0) return 0;
        else return 1;
    }
}