import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14:52 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1000001];
        for(int i=1;i<=1000000;i++) {
            arr[i] = getBadness(i);
        }
        int tc=1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int stop = Integer.parseInt(st.nextToken());
            int badness = Integer.parseInt(st.nextToken());
            if (start == 0 && stop == 0 && badness == 0) break;
            int answer = 0;
            for(int range = start;range <= stop;range++) {
                if (arr[range] <= badness) answer++;
            }
            sb.append("Test ").append(tc++).append(": ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    private static int getBadness(int num) {
        int sum = 1;
        for(int i=2;i*i<=num;i++) {
            if (num%i != 0) continue;
            sum += i;
            if (i*i != num) sum += num/i;
        }
        return Math.abs(sum - num);
    }
}