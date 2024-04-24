import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=N;i>=1;i--) {
            for(int j=N-i;j>=1;j--) sb.append(" ");
            for(int j=1;j<=2*i-1;j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}