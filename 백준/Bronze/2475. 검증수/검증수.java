import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        for(int i=0;i<5;i++) {
            int input = sc.nextInt();
            n += input * input;
        }
        System.out.println(n%10);
    }
}