import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int length = N/5;
        boolean[][] signal = new boolean[5][length];
        for(int i=0;i<N;i++) {
            if (str.charAt(i) == '#') {
                signal[i/length][i%length] = true;
            }
        }

         boolean[][][] pattern = new boolean[][][] {
                 {
                     {true, true, true},
                     {true, false, true},
                     {true, false, true},
                     {true, false, true},
                     {true, true, true}
                 },
                 {
                         {true},
                         {true},
                         {true},
                         {true},
                         {true}
                 },
                 {
                         {true, true, true},
                         {false, false, true},
                         {true, true, true},
                         {true, false, false},
                         {true, true, true}
                 },
                 {
                         {true, true, true},
                         {false, false, true},
                         {true, true, true},
                         {false, false, true},
                         {true, true, true}
                 },
                 {
                         {true, false, true},
                         {true, false, true},
                         {true, true, true},
                         {false, false, true},
                         {false, false, true}
                 },
                 {
                         {true, true, true},
                         {true, false, false},
                         {true, true, true},
                         {false, false, true},
                         {true, true, true}
                 },
                 {
                         {true, true, true},
                         {true, false, false},
                         {true, true, true},
                         {true, false, true},
                         {true, true, true}
                 },
                 {
                         {true, true, true},
                         {false, false, true},
                         {false, false, true},
                         {false, false, true},
                         {false, false, true}
                 },
                 {
                         {true, true, true},
                         {true, false, true},
                         {true, true, true},
                         {true, false, true},
                         {true, true, true}
                 },
                 {
                         {true, true, true},
                         {true, false, true},
                         {true, true, true},
                         {false, false, true},
                         {true, true, true}
                 },
         };

        String answer = "";
        for(int i=0;i<length;i++) { // col
            if (!signal[0][i]) {
                continue;
            }
            int ans = -1;
            outer: for(int j=0;j<=9;j++) {
                for(int a=0;a<5;a++) { // row
                    for(int b=0;b<pattern[j][0].length;b++) { // col
                        if (i+b >= length) continue outer;
                        if (signal[a][i+b] != pattern[j][a][b]) continue outer;
                    }
                }
                ans = j;
                if (j == 1) {
                    continue;
                }
                break;
            }
            answer += ans;
            i += (ans == 1 ? 1 : 2);
        }

        System.out.println(answer);
    }
}
