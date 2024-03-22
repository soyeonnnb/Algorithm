import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 23:11 ~ , 다시/ 13:15 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<2;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[j][i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        for(int i=0;i<N;i++) System.out.println(Arrays.toString(arr[i]));
        long answer = 0;
        for(int i=0;i<N;i++) {
            answer += arr[i][0] + (long) arr[i][1] * i;
        }
        System.out.println(answer);

    }
}