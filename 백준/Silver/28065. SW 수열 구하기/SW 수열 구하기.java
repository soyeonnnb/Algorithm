
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int s = 1;
        int e = N;
        StringBuilder sb = new StringBuilder();
        while(s<=e) {
            sb.append(s++).append(" ");
            if (s<=e) {
                sb.append(e--).append(" ");
            }
        }
        System.out.println(sb);
    }
}
