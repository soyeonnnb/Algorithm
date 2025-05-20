
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        int ans = a.length;
        for(int i=0;i<=b.length - a.length;i++) {
            int count = 0;
            for(int j=0;j<a.length;j++) {
                if (a[j] != b[i + j]) count++;
            }
            ans = Math.min(ans, count);
        }
        System.out.println(ans);
    }
}
