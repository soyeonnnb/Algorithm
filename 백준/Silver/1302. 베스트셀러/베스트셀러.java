
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] strList = new String[N+1];
        int[] arr = new int[N+1];
        int maxIdx = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            int idx = map.getOrDefault(str, ++maxIdx);
            map.put(str, idx);
            arr[idx]++;
            strList[idx] = str;
        }
        int count = 0;
        String ans = "";
        for(int i=1;i<=maxIdx;i++) {
            if (count < arr[i]) {
                ans = strList[i];
                count = arr[i];
            } else if (count == arr[i]) {
                String now = strList[i];
                if (ans.compareTo(now) > 0) {
                    ans = now;
                }
            } 
        }
        System.out.println(ans);
    }
}
