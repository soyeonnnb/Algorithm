import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = 0;
        int k = 0;
        int p = 0;
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c == 'K') {
                if (p > 0) {
                    p--;
                    k++;
                } else {
                    ans++;
                    k++;
                }
            } else { // c == 'P'
                if (k > 0) {
                    k--;
                    p++;
                } else {
                    p++;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
