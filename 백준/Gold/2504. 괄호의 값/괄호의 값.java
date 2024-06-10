import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N=str.length();
        stack = new Stack<>();
        for(int i=0;i<N;i++) {
            if (str.charAt(i) == '(') {
                stack.push(-10);
            } else if (str.charAt(i) == '[') {
                stack.push(-20);
            } else {
                if (str.charAt(i) == ')') stack.push(-11);
                else if (str.charAt(i) == ']') stack.push(-21);
                else stack.push(str.charAt(i)-'0');
                if(!check()) {
                    System.out.println(0);
                    return;
                }
            }
        }
        if (stack.size() != 1 || stack.peek() < 0) System.out.println(0);
        else System.out.println(stack.peek());
    }

    private static boolean check() {
        int now = stack.pop();
//        System.out.println(now);
        if (now == -10 || now == -20) {
            stack.push(now); // 다시 집어넣음
            return true;
        }
        // 만약 숫자이면
        else if (now >= 0) {
            if (stack.isEmpty() || stack.peek() == -10 ||stack.peek() == -20) {
                stack.push(now); // 다시 집어넣음
                return true;
            } else if (stack.peek() >= 0) {
                stack.push(stack.pop() + now);
                return check();
            }
        }
        // 닫는 괄호이면
        else if (now == -11){
            if (stack.isEmpty() || stack.peek() == -20 || stack.peek() == -21 || stack.peek() == -11) return false;
            else if (stack.peek() == -10) {
                stack.pop();
                stack.push(2);
                return check();
            } else {
                int nxt = stack.pop();
                if (stack.isEmpty() || stack.peek() != -10) return false;
                else {
                    stack.pop();
                    stack.push(2 * nxt);
                    return check();
                }
            }
        } else if (now == -21) {
            if (stack.isEmpty() || stack.peek() == -10 || stack.peek() == -11 || stack.peek() == -21) return false;
            else if (stack.peek() == -20) {
                stack.pop();
                stack.push(3);
                return check();
            } else {
                int nxt = stack.pop();
                if (stack.isEmpty() || stack.peek() != -20) return false;
                else {
                    stack.pop();
                    stack.push(3 * nxt);
                    return check();
                }
            }

        }
        return true;
    }
}