import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long A=sc.nextLong()-1;
        Long B=sc.nextLong();

        System.out.println(count(B) - count(A));
    }

    private static Long count(Long num) {
        Long result = 0L;
        long n = 1;

        while(n <= num) {
            result += ((num - n + 1) / (n * 2)) * n;
            long rest = (num - n + 1) % (n * 2);
            result += Math.min(rest, n);
            n*=2;
        }
        return result;
    }
}
