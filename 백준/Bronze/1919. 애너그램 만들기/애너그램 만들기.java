import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[26][2];
        for(int i=0;i<2;i++) {
            String str = sc.next();
            for(int j=0;j<str.length();j++) arr[str.charAt(j) - 'a'][i]++;
        }
        int ans = 0;
        for(int i=0;i<26;i++) ans += Math.abs(arr[i][0] - arr[i][1]);
        System.out.println(ans);
    }
}