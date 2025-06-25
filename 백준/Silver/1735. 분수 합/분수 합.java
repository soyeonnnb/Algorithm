
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int a = a1*b2 + a2*b1;
        int b = b1 * b2;
        int num = 2;
        while(num <= a && num <= b) {
            if (a%num == 0 && b%num == 0) {
                a /= num;
                b /= num;
            } else {
                num++;
            }
        }
        System.out.println(a+" "+b);
    }
}
