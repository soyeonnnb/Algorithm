
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = 0;
        if (str.length() == 1) {
            num = str.charAt(0) - '0';
            System.out.println(0);
            if (num%3 == 0) System.out.println("YES");
            else System.out.println("NO");
            return;
        }

        for(int i=0;i<str.length();i++) {
            num += str.charAt(i) - '0';
        }
        int count = 1;

        while(num >= 10) {
            count++;
            int n = num;
            int s = 0;
            while(n > 0) {
                s += n%10;
                n/=10;
            }
            num = s;
        }
        System.out.println(count);
        if (num%3 == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
