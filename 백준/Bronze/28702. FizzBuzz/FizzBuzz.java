import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        String third = sc.next();
        List<String> arr = new ArrayList<>();
        arr.add("FizzBuzz"); arr.add("Fizz"); arr.add("Buzz");
        int ans = -1;
        if (!arr.contains(first)) {
            ans = Integer.parseInt(first) + 3;
        } else if (!arr.contains(second)) {
            ans = Integer.parseInt(second) + 2;
        } else if (!arr.contains(third)) {
            ans = Integer.parseInt(third) + 1;
        }
        if (ans != -1) {
            System.out.println(getString(ans));
            return;
        }
        int num = 3;
        while(true) {
            num ++ ;
            if (check(num-3, first) && check(num-2, second) && check(num-1, third)) {
                System.out.println(getString(num));
                return;
            }
        }
    }
    private static boolean check(int num, String str) {
       if (str.equals("FizzBuzz")) {
           return num%3 == 0 && num%5 == 0;
       } else if(str.equals("Fizz")) {
           return num%3 == 0 && num%5 != 0;
       } else if (str.equals("Buzz")) {
           return num%3 != 0 && num%5 == 0;
       }
        return false;
    }

    private static String getString(int num) {
        if (num%3 == 0 && num%5 == 0) return "FizzBuzz";
        else if (num%3 == 0) return "Fizz";
        else if (num%5 == 0) return "Buzz";
        else return String.valueOf(num);
    }
}