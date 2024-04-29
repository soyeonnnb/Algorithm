import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N=sc.nextLong();
        long M=sc.nextInt();
        if (N >= M) {
            System.out.println(0);
            return;
        }
        long mul = 1;
        for(int i=1;i<=N;i++) {
            mul *= i;
            mul%=M;
        }
        System.out.println(mul%M);

    }
}