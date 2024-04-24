import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=N;i>=1;i--) {
            for(int j=N;j>i;j--) sb.append(" ");
            for(int k=1;k<=i;k++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}