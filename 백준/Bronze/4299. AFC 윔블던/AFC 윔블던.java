import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int big=a;big>=0;big--) {
            int small = a - big;
            if (big - small == b && a >= b) {
                System.out.println(big+" "+small);
                return;
            }
        }
        System.out.println(-1);
    }
}