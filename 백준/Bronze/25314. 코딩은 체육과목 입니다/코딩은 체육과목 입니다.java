import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i+=4) sb.append("long ");
        sb.append("int");
        System.out.println(sb);
    }
}