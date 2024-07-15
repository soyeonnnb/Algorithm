import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) return;
            else if (a <= b) System.out.println("No");
            else System.out.println("Yes");
        }
    }
}