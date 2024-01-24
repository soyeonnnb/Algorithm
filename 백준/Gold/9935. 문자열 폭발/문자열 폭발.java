import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        char[] bomb = sc.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=str.length-1;i>=0;i--) {
            stack.push(str[i]);
            if (stack.size() >= bomb.length) {
                boolean flag = true;
                for(int j=bomb.length-1;j>=0;j--) {
                    if (stack.get(stack.size()-1-j)!=bomb[j]) {
                        flag=false;
                        break;
                    }
                }
                if (flag) {
                    for(int j=0;j<bomb.length;j++) stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.length()==0?"FRULA":sb.toString());
    }
}