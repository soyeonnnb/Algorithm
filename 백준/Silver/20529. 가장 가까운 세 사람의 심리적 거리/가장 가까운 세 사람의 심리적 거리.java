import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][][][] arr;
        int[] now = new int[4];
        List<String> list = new ArrayList<>();
        test: for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[2][2][2][2];
            list.clear();
            for(int i=0;i<N;i++) {
                String str = st.nextToken();
                Arrays.fill(now, 0);
                if (str.charAt(0) == 'I') now[0] = 1;
                if (str.charAt(1) == 'N') now[1] = 1;
                if (str.charAt(2) == 'F') now[2] = 1;
                if (str.charAt(3) == 'P') now[3] = 1;
                arr[now[0]][now[1]][now[2]][now[3]] ++;
                if (arr[now[0]][now[1]][now[2]][now[3]] == 3) {
                    System.out.println(0);
                    continue test;
                }
                list.add(str);
            }
            int answer =100000;
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    for(int k=j+1;k<N;k++) {
                        answer = Math.min(answer, get(list.get(i), list.get(j))+get(list.get(j), list.get(k))+get(list.get(i), list.get(k)));
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static int get(String str1, String str2) {
        int result = 0;
        for(int i=0;i<4;i++) {
            if (str1.charAt(i) != str2.charAt(i)) result++;
        }
        return result;
    }
}