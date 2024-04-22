import java.util.*;

class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N=sc.nextInt();
            int[] arr = new int[]{0, 1, 1};
            
            for(int i=3;i<=N;i++) {
                 arr[i%3] = arr[(i+1)%3] + arr[(i+2)%3];
            }
            
            System.out.println(arr[N%3]);
            
        }
}