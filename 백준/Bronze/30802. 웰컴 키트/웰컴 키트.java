import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr = new int[6];
        for(int i=0;i<6;i++) arr[i] = sc.nextInt();
        int T=sc.nextInt();
        int P=sc.nextInt();
        int t = 0;
        for(int i=0;i<6;i++) {
            t += arr[i]/T + (arr[i]%T == 0 ? 0 : 1);
        }
        System.out.println(t);
        System.out.println(N/P+" "+N%P);

    }
}