import java.beans.BeanInfo;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        BigInteger[] arr = new BigInteger[]{BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE};
        for(int i=3;i<=N;i++) {
            arr[i%3] = arr[(i+1)%3].add(arr[(i+2)%3]);
        }
        System.out.println(arr[N%3]);
    }
}
