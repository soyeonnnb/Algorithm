import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr= new int[4][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) arr[j][i] = Integer.parseInt(st.nextToken());
        }
        int[] ab =new int[N*N];
        int[] cd =new int[N*N];
        int idx = 0 ;
        for(int i=0;i<N;i++) { // 4000 * 4000
            for(int j=0;j<N;j++) {
                ab[idx] = arr[0][i] + arr[1][j];
                cd[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        long answer = 0;
        int s = 0;
        int e = N*N-1;
        while(s < N*N && e >= 0) {
            int sum = ab[s] + cd[e];
            if (sum > 0) {
                e--;
            } else if (sum < 0) {
                s++;
            } else {
                int abnow = ab[s];
                long abnumber = 0;
                while(s < N*N && ab[s] == abnow) {
                    abnumber++;
                    s++;
                }
                int cdnow = cd[e];
                long cdnumber = 0;
                while(e >= 0 && cd[e] == cdnow) {
                    cdnumber++;
                    e--;
                }
                answer += abnumber * cdnumber;
            }
        }

        System.out.println(answer);
    }
}