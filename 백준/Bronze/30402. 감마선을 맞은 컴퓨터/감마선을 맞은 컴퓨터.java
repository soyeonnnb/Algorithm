import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<15*15;i++) {
            String str = sc.next();
            if (str.charAt(0) == 'w') {
                System.out.println("chunbae");
                return;
            } else if (str.charAt(0) == 'b') {
                System.out.println("nabi");
                return;
            } else if (str.charAt(0) == 'g') {
                System.out.println("yeongcheol");
                return;
            }
        }
    }
}