import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13:45 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        int[] rArr = new int[N];
        int[] bArr = new int[N];
        String str = br.readLine();
        for(int i=0;i<N;i++) {
            if (str.charAt(i) == 'R') rArr[i] = 1;
            else if (str.charAt(i) == 'B') bArr[i] = 1;
        }
        for(int i=1;i<N;i++) {
            rArr[i] += rArr[i-1];
            bArr[i] += bArr[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int rs, re, bs, be;
            if (str.charAt(start) == 'R') rs = start;
            else rs = binary(rArr, rArr[start]+1, start, end);
            if (rs>=N ||rs<0|| str.charAt(rs) != 'R') {
                sb.append("-1\n");
                continue;
            }
            re = binary(rArr, rArr[rs]+1, rs+1, end);
            if (re>=N ||re<0|| str.charAt(re) != 'R') {
                sb.append("-1\n");
                continue;
            }
            if (rs >= re) {
                sb.append("-1\n");
                continue;
            }
            if (re+1 < N && str.charAt(re+1) == 'B') bs = re+1;
            else bs = binary(bArr, bArr[re]+1, re+1, end);
            if (bs>=N ||bs<0|| str.charAt(bs) != 'B' || re >= bs) {
                sb.append("-1\n");
                continue;
            }
            be = binary(bArr, bArr[bs]+1, bs+1, end);
            if (be>=N || be<0||str.charAt(be) != 'B') {
                sb.append("-1\n");
                continue;
            }
            if (bs >= be || be > end) {
                sb.append("-1\n");
                continue;
            }
            sb.append(rs).append(" ").append(re).append(" ").append(bs).append(" ").append(be).append("\n");
        }
        System.out.println(sb);
    }
    private static int binary(int[] arr, int num, int start, int finish) {
        int s = start;
        int e = finish;
        while(s<=e) {
            int mid = (s+e)/2;
            if (arr[mid] < num) s = mid+1;
            else e = mid-1;
        }
        return s;
    }
}