import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5 5
//1 2 3 4 5
//1 1 1 1 1


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] narr = new int[N];
        int[] marr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) narr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) marr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(narr);
        Arrays.sort(marr);

        long[] answer = new long[3]; // n 기준으로 이기고, 지고, 비기고
        int s=0, e=M-1, l=0, r=0;
        for(int i=0;i<N;i++) {
            int score = narr[i];
            s = 0;
            e = M-1;
            l = M; // lower_bound
            r = M; // upper_bound
            while(s <= e) {
                int mid = (s+e)/2;
                if (marr[mid] < score) {
                    s = mid+1;
                } else {
                    l = mid;
                    e = mid-1;
                }
            }
            s = 0;
            e = M-1;
            while(s <= e) {
                int mid = (s+e)/2;
                if (marr[mid] <= score) {
                    s = mid+1;
                } else {
                    r = mid;
                    e = mid-1;
                }
            }
//            System.out.println(score+" "+l+" "+r);
            answer[0] += l; // 이기고
            answer[1] += M-r; // 지고
            answer[2] += r-l; // 비기고
        }
        for(int i=0;i<3;i++) System.out.print(answer[i]+" ");

    }
}