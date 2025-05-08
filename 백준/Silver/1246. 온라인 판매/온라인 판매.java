
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        for(int i=0;i<M;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = 0;
        int price = 0;
        for(int i=1;i<=1_000_000;i++) {
            int index = getCount(i, arr);
            if (index < 0 || index >= M) continue;
            int count = M - index;
            if (count > N) continue;
            if (count * i > price) {
                ans = i;
                price = count * i;
            }

        }
        System.out.println(ans +" " + price);
    }

    private static int getCount(int num, int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while(s <= e) {
            int mid = (s+e) / 2;
            if (arr[mid] < num) {
                s = mid+1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }
}
