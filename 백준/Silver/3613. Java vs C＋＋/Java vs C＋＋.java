import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean isJ = true;
        boolean isC = true;
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == '_') {
                isJ = false;
            } else if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                isC = false;
            }
        }
        if (!isJ && !isC) {
            System.out.println("Error!");
            return;
        }
        if (str.charAt(0) == '_' || str.charAt(str.length()-1) == '_') {
            System.out.println("Error!");
            return;
        }

        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
            System.out.println("Error!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (isJ) {
            sb.append(str.charAt(0));
            for(int i=1;i<str.length();i++) {
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    sb.append("_").append((char) (str.charAt(i) - 'A' + 'a'));
                } else {
                    sb.append(str.charAt(i));
                }
            }
        } else {
            sb.append(str.charAt(0));
            for(int i=1;i<str.length();i++) {
                if (str.charAt(i) == '_') {
                    if (str.charAt(i+1) == '_') {
                        System.out.println("Error!");
                        return;
                    }
                    sb.append((char) (str.charAt(i+1) - 'a' + 'A'));
                    i++;
                } else {
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}