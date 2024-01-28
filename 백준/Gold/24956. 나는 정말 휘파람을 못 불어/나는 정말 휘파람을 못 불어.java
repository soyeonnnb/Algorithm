import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        String str = sc.next();
        int[] wArr = new int[N+1];
        int[] eArr = new int[N+1];

        List<Integer> hList = new ArrayList<>();

        // 해당 자리까지 w, e가 몇번 나왔는지
        for(int i=0;i<N;i++) {
            if (str.charAt(i) == 'W') wArr[i+1]++;
            else if (str.charAt(i) == 'H') hList.add(i+1);
            else if (str.charAt(i) == 'E') eArr[i+1]++;
        }

        for(int i=1;i<=N;i++) wArr[i] += wArr[i-1];
        for(int i=1;i<=N;i++) eArr[i] += eArr[i-1];

        long answer =0;
        for(int h : hList) {
            answer += (wArr[h]) * get(eArr[N] - eArr[h]);
            answer %= MOD;
        }

        answer %= MOD;
        System.out.println(answer);
    }

    private static long get(long num) {
        // 다 있든 말든 - 0개나 1개인 경우
        long result = pow(num);
//        System.out.println(result);
        result -= num+1;
        result %= MOD;
        return result;
    }


    private static long pow(long num) {
//        System.out.println(num);
        if (num == 0) return 1L;
        else if (num%2 == 0) {
            long result = pow(num/2)%MOD;
//            System.out.println(num+" "+result);
            return (result * result)%MOD;
        } else {
            long result = pow(num/2)%MOD;
//            System.out.println(num+" "+result);
            return (2 * result * result)%MOD;
        }
    }
}