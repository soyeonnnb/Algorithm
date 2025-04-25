
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int idx = 0;
            switch (str.charAt(0)) {
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    idx++;
                    break;
                case 'A':
                    break;
                default:
                    System.out.println("Good");
                    continue;
            }
            if (idx >= str.length() || str.charAt(idx) != 'A') {
                System.out.println("Good");
                continue;
            }
            while(idx < str.length() && str.charAt(idx) == 'A') {
                idx++;
            }
            if (idx >= str.length() || str.charAt(idx) != 'F') {
                System.out.println("Good");
                continue;
            }
            while(idx < str.length() && str.charAt(idx) == 'F'){
                idx++;
            }
            if (idx >= str.length() || str.charAt(idx) != 'C') {
                System.out.println("Good");
                continue;
            }
            while(idx < str.length() && str.charAt(idx) == 'C'){
                idx++;
            }
            if (idx == str.length() || (str.charAt(str.length()-1) >= 'A' && str.charAt(str.length()-1) <= 'F')) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }
    }

}
