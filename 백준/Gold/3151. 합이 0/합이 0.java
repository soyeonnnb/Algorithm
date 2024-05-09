import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12:11 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer> minusList = new ArrayList<>(N);
        List<Integer> plusList = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int zero = 0;
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) zero++;
            if(input < 0) minusList.add(input * -1);
            else plusList.add(input);
        }
        int[] plusSum = new int[20001];
        int[] minusSum = new int[20001];
        for(int i=0;i<plusList.size();i++) {
            for(int j=i+1;j<plusList.size();j++) plusSum[plusList.get(i) + plusList.get(j)]++;
        }
        for(int i=0;i<minusList.size();i++) {
            for(int j=i+1;j<minusList.size();j++) minusSum[minusList.get(i) + minusList.get(j)]++;
        }
        long ans = 0;
        for(int i=0;i<plusList.size();i++) ans += minusSum[plusList.get(i)];
        for(int i=0;i<minusList.size();i++) ans += plusSum[minusList.get(i)];
        if (zero >= 3) {
            long temp = zero * (long)(zero-1) * (zero-2);
            ans += temp/6;
        }
        System.out.println(ans);

    }
}