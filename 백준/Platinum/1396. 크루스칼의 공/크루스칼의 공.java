import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 20:27 ~
public class Main {
    private static int[][] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][3];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(br.readLine());
        int[][] query = new int[Q][2];
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) query[i][j] = Integer.parseInt(st.nextToken());
        }
        parents = new int[N+1][2]; // 루트 기준으로 몇 개의 자식이 포함되어 있는지
        int[][] binary = new int[Q][2];
        for(int i=0;i<Q;i++) {
            binary[i][0] = 1;
            binary[i][1] = 1000000;
        }
        // 간선 그거 대로 변경
        // 온도가 낮은 것부터 확인할거임 -> 온도가 같거나 높아야하니까 낮은거부터 ㄱㄱ
        Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);
        List<int[]> list = new ArrayList<>();
        int[][] answer = new int[Q][2];
        for(int i=0;i<Q;i++) answer[i][0] = -1;
        while(true) {
            for(int i=0;i<=N;i++) {
                parents[i][0] = i; // 각 노드의 부모 번호
                parents[i][1] = 1; // 부모 기준만 생각 -> 몇 개의 노드가 포함되어 있는지
            }
            list.clear();
            for(int i=0;i<Q;i++) {
                if (binary[i][0] > binary[i][1]) continue; // 이진 탐색이 끝난 경우에는 생각 X
                list.add(new int[]{(binary[i][0] + binary[i][1])/2, i}); // 중앙값(해당 쿼리의 온도)와 쿼리번호
            }
            if (list.isEmpty()) break; // list가 빈 경우 -> 생각 X
            list.sort((o1, o2) -> o1[0] - o2[0]);
            int idx = 0; // 각 간선을 보면서
//            for(int i=list.size()-1;i>=0;i--) {
            for(int i=0;i<list.size();i++) {
                // 일단 내려갈 수 있을 만큼 계속 내려가기
                while(idx < M && arr[idx][2] <= list.get(i)[0]) {
                    union(arr[idx][0], arr[idx][1]);
                    idx++;
                }
                // 만약 같은 집합이면 해당 온도로 움직일 수 있음 == 더 최소인게 있나 확인해보자
                if (findset(query[list.get(i)[1]][0]) == findset(query[list.get(i)[1]][1])) {
                    answer[list.get(i)[1]][0] = list.get(i)[0]; // 이 온도면 같은 집합 가능
                    answer[list.get(i)[1]][1] = parents[findset(query[list.get(i)[1]][0])][1];
                    binary[list.get(i)[1]][1] = list.get(i)[0]-1;
                } else {
                    binary[list.get(i)[1]][0] = list.get(i)[0]+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            if (answer[i][0] == -1) sb.append("-1\n");
            else sb.append(answer[i][0] +" "+answer[i][1]+"\n");
        }
        System.out.println(sb);
    }
    private static int findset(int x) {
        if (parents[x][0] == x) return x;
        else return parents[x][0] = findset(parents[x][0]);
    }
    private static void union(int x, int y) {
        int rx = findset(x);
        int ry = findset(y);
        if (rx == ry) return;
        else if (rx < ry) {
            parents[rx][1] += parents[ry][1];
            parents[ry][0] = rx;
        } else {
            parents[ry][1] += parents[rx][1];
            parents[rx][0] = ry;
        }
    }
}