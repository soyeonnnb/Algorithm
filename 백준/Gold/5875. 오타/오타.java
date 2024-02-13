import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N=str.length();
        int[] arr= new int[N];
        for(int i=0;i<N;i++) {
            if (str.charAt(i) == '(') arr[i] = 1;
            else arr[i] = -1;
        }
        for(int i=1;i<N;i++) arr[i] += arr[i-1];
        boolean[] prefix = new boolean[N+1]; // i번째 까지 음수가 없는지 T/F
        boolean[] suffix = new boolean[N+1]; // [i, n] 구간이 모두 2 이상인지 T/F
        prefix[0] = true;
        for(int i=0;i<N;i++) {
            if (arr[i]>=0) prefix[i+1] = true;
            else break;
        }
        for(int i=N-1;i>=0;i--) {
            if (arr[i] >= 2) suffix[i+1] = true;
            else {
                suffix[i+1] = true;
                break;
            }
        }
        int answer = 0;
        if (str.charAt(0) == ')' || str.charAt(N-1) == '(') {
            System.out.println(1);
            return;
        }
        if (arr[N-1] == -2) { // ) -> ( 로 바꿔야 함
            // 즉 +2 해야함 !
            for(int i=0;i<N-1 && prefix[i];i++) {
                if (str.charAt(i) == ')') answer++;
            }
            
        } else { // ( -> ) 로 바꿔야 함
            // 즉 -2 해야함 !
            for(int i=N-1;i >= 1 && suffix[i];i--) {
                if (str.charAt(i) == '(') answer++;
            }
        }
        System.out.println(answer);
    }
}