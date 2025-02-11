import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 21:43 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=N;tc++) {
            String str = br.readLine();
            sb.append(isPel(str)).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPel(String str) {
        int s = 0;
        int e = str.length()-1;
        while(s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                int tempS = s;
                int tempE = e-1;
                while(tempS <= tempE) {
                    if (str.charAt(tempS) == str.charAt(tempE)) {
                        tempS++;
                        tempE--;
                    } else  {
                        tempS = s+1;
                        tempE = e;
                        while(tempS <= tempE) {
                            if (str.charAt(tempS) == str.charAt(tempE)) {
                                tempS++;
                                tempE--;
                            } else {
                                return 2;
                            }
                        }
                        return 1;
                    }
                }
                return 1;

            }
        }
        return 0;
    }
}