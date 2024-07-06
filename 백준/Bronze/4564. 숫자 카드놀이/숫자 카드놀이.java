import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = sc.next();
            if (str.equals("0")) break;
            while(str.length() > 1) {
                sb.append(str).append(" ");
                str = getNextNum(str);
            }
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
    private static String getNextNum(String num) {
        int result = 1;
        for(int i=0;i<num.length();i++) result *= num.charAt(i) - '0';
        return String.valueOf(result);
    }
}