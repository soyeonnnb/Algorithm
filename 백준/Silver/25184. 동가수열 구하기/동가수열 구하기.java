import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int diff = N/2;
        int s = N-diff;
        int e = N;
        int start = N-diff;
        while(s>=1) {
            sb.append(s--).append(" ");
            if (e > start) sb.append(e--).append(" ");
        }
        System.out.println(sb);
    }
}
