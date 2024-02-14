import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()+1];
        int[] exist_s = new int[str.length()+1];
        Map<Integer, Integer> minMap = new TreeMap<>();
        Map<Integer, Integer> maxMap = new TreeMap<>();
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == 'S') {
                arr[i+1]=2;
                exist_s[i+1]=1;
            }
            else if (str.charAt(i) == 'K') arr[i+1]=-1;
        }
        minMap.put(0, 0);
        maxMap.put(0, 0);
        for(int i=1;i<=str.length();i++) {
            arr[i] += arr[i-1];
            if (minMap.containsKey(arr[i])) {
                maxMap.put(arr[i], i);
            } else {
                minMap.put(arr[i], i);
                maxMap.put(arr[i], i);
            }
            exist_s[i] += exist_s[i-1];
        }
        int answer = -1;
        Set<Integer> keys = minMap.keySet();
        for(Integer k : keys) {
            Integer s = minMap.get(k);
            Integer e = maxMap.get(k);
            if (s == e) continue;
            else if (arr[e] == arr[s] && exist_s[e] - exist_s[s] > 0) {
                answer = Math.max(answer, e-s);
            }
        }
        System.out.println(answer);
    }
}