
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
//        int[] arr = new int[2010];
//        arr[1] = 1;
//        arr[2] = 1; // 1 1 2 3
//        for(int i=3;i<=2000;i++) arr[i] = arr[i-1] + arr[i-2];
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int i = N;
        for(;i>=3;i-=3) {
            list1.add(i);
            list2.add(i-1);
            list2.add(i-2);
        }
        if (i == 2) {
            list1.add(1);
            list2.add(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list1.size()).append("\n");
        list1.sort(Comparator.naturalOrder());
        for(Integer num : list1) sb.append(num).append(" ");
        sb.append("\n");
        sb.append(list2.size()).append("\n");
        list2.sort(Comparator.naturalOrder());
        for(Integer num : list2) sb.append(num).append(" ");
        sb.append("\n");
        System.out.println(sb);

    }
}
