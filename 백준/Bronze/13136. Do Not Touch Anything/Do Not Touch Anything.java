import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long R=sc.nextLong();
        long C=sc.nextLong();
        long N=sc.nextLong();
        System.out.println((R/N + (R%N == 0 ? 0 : 1)) * (C/N + (C%N == 0 ? 0 : 1)));
    }
}