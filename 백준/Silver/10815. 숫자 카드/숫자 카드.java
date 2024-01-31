import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken())+10000000;
        int M=Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) arr2[i] = Integer.parseInt(st.nextToken())+10000000;
        int[] count = new int[20000010];
        for(int i=0;i<N;i++) count[arr[i]]++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            if (count[arr2[i]]>0) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }
}