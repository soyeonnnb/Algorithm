import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 1000;
        int sum = 0;
        for(int i=0;i<7;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num%2 == 0) continue;
            min = Math.min(min, num);
            sum += num;
        }
        if(sum == 0) System.out.println(-1);
        else System.out.println(sum+"\n"+min);
    }
}