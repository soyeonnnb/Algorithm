import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        if (b < a) {
            long t = a;
            a = b;
            b = t;
        }
        if (b-a-1 >= 0) sb.append(b-a-1);
        else sb.append(0);
        sb.append("\n");
        for(long i=a+1;i<b;i++) sb.append(i).append(" ");
        System.out.println(sb);
    }
}