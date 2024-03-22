import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 병렬 이진탐색 사용
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][3];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // 운하의 폭을 이용해서 이진탐색을 할 것이므로 정렬!
        Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);

        // 이진탐색을 할건데, 쿼리별로 한번에 묶어서 할 거니까!!
        int[][] query = new int[K][2];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) query[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] binary = new int[K][2]; // 이걸 이용해서 각 쿼리별로 s랑 e 저장
        for(int i=0;i<K;i++) {
            binary[i][0] = 1;
            binary[i][1] = 200;
        }
        int[] answer = new int[K];
        parents = new int[N+1];
        // 계속 돌면서 확인할거임
        List<int[]> list = new ArrayList<>();
        while(true) {
            for(int i=0;i<=N;i++) parents[i] = i;
            list.clear();
            for(int i=0;i<K;i++) {
                if (binary[i][0] > binary[i][1]) continue; // 이미 이진탐색이 끝났으면
                list.add(new int[]{(binary[i][0] + binary[i][1])/2, i}); // mid값이랑 query 번호랑 같이 저장
            }
            if (list.isEmpty()) break;
            list.sort((o1, o2) -> o1[0] - o2[0]);
            int idx = M-1; // 각 운하를 확인할거임
            for(int i=list.size()-1;i>=0;i--) { // 쿼리를 보면서
                // 만약 더 합쳐도 되면(현재 타겟하고 있는 운하가 내가 찾으려는 것보다 크면)
                while (idx >= 0 && arr[idx][2] >= list.get(i)[0]) {
                    union(arr[idx][0], arr[idx][1]); // 해당 도시를 연결하기
                    idx--;
                }
                // 같은 집합이면(합쳐졌으면) 더 큰 운하도 가능한가 확인하면 됨
                if (findset(query[list.get(i)[1]][0]) == findset(query[list.get(i)[1]][1])) {
                    answer[list.get(i)[1]] = list.get(i)[0];
                    binary[list.get(i)[1]][0] = list.get(i)[0] + 1;
                } else { // 같은 집합이 아니면 더 작은 운하여야 함
                    binary[list.get(i)[1]][1] = list.get(i)[0] - 1;
                }
            }
        }
        for(int x : answer) System.out.println(x);
    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }
    private static void union(int x, int y) {
        int rx = findset(x);
        int ry = findset(y);
        if (rx < ry) parents[ry] = rx;
        else parents[rx] = ry;
    }
}