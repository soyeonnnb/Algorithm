import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int ans = 0;
        int[] arr = new int[]{500, 100, 50, 10, 5, 1};
        for(int i=0;i<6;i++) {
            ans += money/arr[i];
            money%=arr[i];
        }
        System.out.println(ans);
    }
}