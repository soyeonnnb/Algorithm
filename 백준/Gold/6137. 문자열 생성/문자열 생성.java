import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 13:57 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        for(int i=0;i<N;i++) arr[i] = br.readLine().charAt(0);
        StringBuilder sb = new StringBuilder();
        int s = 0;
        int e = N-1;

        while(s<=e) {
            if (arr[s] > arr[e]) {
                sb.append(arr[e--]);
            } else if (arr[s] < arr[e]) {
                sb.append(arr[s++]);
            } else {
                int d_s = s+1;
                int d_e = e-1;
                sb.append(arr[s]);
                while(d_s <= d_e && arr[d_s] == arr[d_e]) {
                    d_s++;
                    d_e--;
                }
                if (d_s > d_e) {
                    s++;
                } else if (arr[d_s] < arr[d_e]) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        while(sb.length() != 0){
            System.out.println(sb.substring(0, Math.min(80, sb.length())));
            sb.delete(0, Math.min(80, sb.length()));
        }

    }
}