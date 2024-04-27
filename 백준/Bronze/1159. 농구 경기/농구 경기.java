import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new TreeMap<>();
        int N=Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            char ch = str.charAt(0);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if (map.get(ch) == 5) list.add(ch);
        }
        if (list.size() == 0) {
            System.out.println("PREDAJA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        list.sort(Comparator.naturalOrder());
        for(Character ch : list) sb.append(ch);
        System.out.println(sb);

    }
}