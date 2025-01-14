import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        String first = before;
        Set<String> set = new HashSet<>();
        set.add(first);
        String last = new String(before);
        boolean flag = true;
        for(int tc=1;tc<36;tc++) {
            String now = br.readLine();
            if (check(before, now)) {
                before = now;
                set.add(now);
                last = now;
            } else {
                flag = false;
                break;
            }
        }
        if (set.size() != 36) {
            flag = false;
        }

        if (!check(first, last)) {
            flag = false;
        }
        System.out.println(flag ? "Valid" : "Invalid");
    }

    private static boolean check(String a, String b) {
        int alpa = Math.abs(a.charAt(0) - b.charAt(0));
        int number = Math.abs(a.charAt(1) - b.charAt(1));
        if (!((alpa == 1 && number == 2) || (alpa == 2 && number == 1))) {
            return false;
        } else return true;
    }
}