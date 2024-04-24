import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i=N-1;i>=0;i--) {
            for(int j=0;j<i;j++) sb.append(" ");
            for(int j=0;j<num;j++) sb.append("*");
            sb.append("\n");
            num+=2;
        }
        System.out.println(sb);
    }
}