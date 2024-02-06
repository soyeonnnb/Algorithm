import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr =new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N+1];
        for(int i=1;i<=N;i++) prefix[i] = prefix[i-1] + arr[i];
        int weight = 0;
        int diff = 200000000;
        int s;
        int e;
        for(int i=1;i<=N;i++) {
            for(int j=i+1;j<=N;j++) {
                // i에서 j까지의 학생에 대하여 구할건데, 그 나누는 기준 -> 첫번째 그룹의 마지막 학생을 mid로 두자
                s = i;
                e = j-1;
                while(s <= e) {
                    int mid = (s+e)/2;
                    int sum = prefix[j] - prefix[i-1];
                    int left = prefix[mid] - prefix[i-1];
                    int right = prefix[j] - prefix[mid];
                    if (left > right) {
                        if (diff > left-right) {
                            diff = left - right;
                            weight = sum;
                        } else if (diff == left-right) weight = Math.max(weight, sum);
                        e = mid-1;
                    } else if (left < right) {
                        if (diff > right - left) {
                            diff = right - left;
                            weight = sum;
                        } else if (diff == right - left) weight = Math.max(weight, sum);
                        s=mid+1;
                    } else {
                        if(diff == 0) weight = Math.max(weight, sum);
                        else {
                            diff = 0;
                            weight = sum;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(weight);
    }
}