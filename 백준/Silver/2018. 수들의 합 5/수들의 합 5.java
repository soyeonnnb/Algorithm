import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int s = 1;
        int e = 1;
        int sum = 1;
        int count = 0;
        while(s <= e && e <= N) {
            if (sum < N) {
                e++;
                sum += e;
            } else if (sum > N) {
                sum -= s;
                s++;
            } else {
                count++;
                sum -= s;
                s++;
            }
        }
        System.out.println(count);
    }
}