import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        int present = 1;
        int memory = 1;
        StringBuilder sb = new StringBuilder();
        while(memory < G) {
            int now = present * present - memory * memory;
            if (now == G) {
                sb.append(present+"\n");
                present++;
            } else if (now < G) {
                present++;
            } else {
                memory++;
            }
        }
        System.out.println(sb.length() == 0 ? "-1" : sb.toString());
    }
}
