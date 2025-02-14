import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int N=Integer.parseInt(br.readLine());
            if (N == 0) break;
            String str = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            int s = 0;
            int e = 0;
            int count = 0;
            int length = 0;

            while(e < str.length()) {
                int c = map.getOrDefault(str.charAt(e), 0);
                if (count < N) {
                    if (c == 0) count++;
                } else {
                    if (c == 0) break;
                }
                map.put(str.charAt(e), c + 1);
                e++;
                length ++;
            }

            int max = length;
            while(e < str.length()) {
                int c = map.getOrDefault(str.charAt(e), 0);
                // 늘릴 수 있음
                if (c != 0) {
                    length++;
                    map.put(str.charAt(e), c + 1);
                    e++;
                } else { // 처음 나온 알파벳
                    // 늘릴 수 있음
                    if (count != N) {
                        count++;
                        map.put(str.charAt(e), c + 1);
                        e++;
                        length++;
                    } else { // 늘릴 수 없음 == s를 줄임
                        int sc = map.get(str.charAt(s));
                        length--;
                        if (sc == 1) count--;
                        map.put(str.charAt(s), sc-1);
                        s++;
                    }
                }
                max = Math.max(max, length);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}