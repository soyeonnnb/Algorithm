import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] prime = new int[100010][3];
        int idx = 0;
        int num = 0;
        for(int i=1;i<=100000;i++) {
            if (isPrime(i)) {
                prime[i][idx] = i;
                idx = (idx + 1) % 2;
                prime[i][2] = ++num;
            } else {
                prime[i][2] = prime[i-1][2];
            }
        }
        for(int i=1;i<=100000;i++) for(int j=0;j<2;j++) prime[i][j] += prime[i-1][j];

        StringBuilder sb = new StringBuilder();

        for(int n=0;n<N;n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            idx = prime[a][2];
            if (prime[a-1][2] != prime[a][2]) idx++;
            idx%=2;
            long result = (prime[b][idx] - prime[a-1][idx])*3L;
            idx = (idx+1)%2;
            result -= prime[b][idx] - prime[a-1][idx];

            sb.append(result).append("\n");

        }
        System.out.println(sb);


    }
    private static boolean isPrime(int num) {
        if (num == 1) return false;
        else if (num <= 3) return true;
        for(int i=2;i*i<=num;i++) {
            if (num%i == 0) return false;
        }

        return true;
    }
}