import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("2000\n");
        for(int i=0;i<1000;i++) sb.append("1 ");
        for(int i=0;i<1000;i++) sb.append("1000 ");
        System.out.println(sb);
    }
}