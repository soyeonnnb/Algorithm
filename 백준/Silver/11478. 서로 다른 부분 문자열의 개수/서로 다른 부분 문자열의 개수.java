

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        String str = sc.next();
        for(int i=0;i<str.length();i++) {
            for(int j=i+1;j<=str.length();j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
