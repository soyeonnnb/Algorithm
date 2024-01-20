import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();int B=sc.nextInt();int W=sc.nextInt();
        boolean[] isBlack = new boolean[N];
        String str = sc.next();
        for(int i=0;i<N;i++) isBlack[i] = str.charAt(i) == 'B';
        int cntBlack = 0;
        int cntWhite = 0;
        if (isBlack[0]) cntBlack++; else cntWhite++;
        int answer = 0;
        int s = 0;
        int e = 0;
        while(s<N && e<N) {
            if (cntBlack <= B && cntWhite >= W) {
                answer = Math.max(answer, e-s+1);
                e++;
                if (e<N) {
                    if (isBlack[e]) cntBlack++; else cntWhite++;
                }
            } else if (cntBlack > B) {
                if (isBlack[s++]) cntBlack--; else cntWhite--;
            } else if (cntWhite < W) {
                e++;
                if (e<N) {
                    if (isBlack[e]) cntBlack++; else cntWhite++;
                }
            }
        }
        System.out.println(answer);
    }
}