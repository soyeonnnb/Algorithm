import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            temp.delete(0, temp.length());
            int count = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            for(int i=0;i<count;i++) temp.append(ch);
            sb.append(temp+"\n");
        }
        System.out.println(sb);
    }
}