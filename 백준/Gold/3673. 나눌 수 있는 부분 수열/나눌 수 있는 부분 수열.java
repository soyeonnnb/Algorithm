import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[50002];
        int[] count = new int[1000002];
        for(int c=0;c<C;c++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Arrays.fill(arr, 0);
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(count, 0);
            int sum = 0;
            // 해당 자리수까지 더했을 때의 나머지 배열
            for(int i=1;i<=n;i++) {
                count[(sum + arr[i])%d]++;
                sum += arr[i];
                sum %= d;
            }
            // 해당 자리수 이후로 해서 현재 나머지랑 x랑 더했을 때 나머지가 0인 개수 구하기
            // 즉 x = d - 현재 나머지 라고 할 때, x의 개수 구하기.
//            System.out.println(Arrays.toString(count));
            long answer = 0;
            sum = 0;
            for(int i=1;i<=n;i++) {
//                System.out.println(i+" "+sum+" "+count[sum]);
                answer += count[sum];
                sum += arr[i];
                sum %= d;
                count[sum]--;
            }


            System.out.println(answer);

        }
    }
}