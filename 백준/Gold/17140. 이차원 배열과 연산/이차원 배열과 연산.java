import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 19:35 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[100][100];
        for(int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int rowNum = 3;
        int colNum = 3;

        for(int tc=0;tc<=100;tc++) {

//            System.out.println(tc +" "+rowNum+" "+colNum);
//            for(int i=0;i<rowNum;i++) System.out.println(Arrays.toString(arr[i]));
            if (arr[r][c] == k) {
                System.out.println(tc);
                return;
            }

            if (rowNum >= colNum) {
                int maxColNum = 0;
                for(int i=0;i<rowNum;i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for(int j=0;j<colNum;j++) {
                        if (arr[i][j] == 0) continue;
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }
                    maxColNum = Math.min(100, Math.max(maxColNum, map.size() * 2));
                    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
                    for(Integer key : map.keySet()) pq.add(new int[]{key, map.get(key)});

                    Arrays.fill(arr[i], 0);
                    int idx = 0 ;
                    while(!pq.isEmpty() && idx < 100) {
                        int[] now = pq.poll();
                        arr[i][idx++] = now[0];
                        arr[i][idx++] = now[1];
                    }
                }
                colNum = maxColNum;
            } else {
                int maxRowNum = 0;
                for(int j=0;j<colNum;j++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for(int i=0;i<rowNum;i++) {
                        if (arr[i][j] == 0) continue;
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }
                    maxRowNum = Math.min(Math.max(maxRowNum, map.size() * 2), 100);
                    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
                    for(Integer key : map.keySet()) pq.add(new int[]{key, map.get(key)});

                    for(int t=0;t<100;t++) arr[t][j] = 0;
                    int idx = 0 ;
                    while(!pq.isEmpty() && idx < 100) {
                        int[] now = pq.poll();
                        if (now[0] == 0) {
                            System.out.println("0있음");
                        }
                        arr[idx++][j] = now[0];
                        arr[idx++][j] = now[1];
                    }
                }
                rowNum = maxRowNum;
            }

        }
        System.out.println(-1);
    }
}