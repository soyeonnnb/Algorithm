import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        int N=a.length;
        long[] result = new long[N];
        for(int i=0;i<N;i++) result[i] = a[i];
        int[] connected = new int[N]; // 리프노드인지 확인
        List<Integer>[] list = new ArrayList[N];
        for(int i=0;i<N;i++) list[i] = new ArrayList<>();
        for(int[] e : edges) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
            connected[e[0]]++;
            connected[e[1]]++;
        }
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<N;i++) if(connected[i] == 1) {
            queue.add(i);
            visited[i] = true;
        }
        outer: while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int num : list[now]) {
                if (visited[num]) continue;
                else {
                    answer += Math.abs(result[now]);
                    result[num] += result[now];
                    connected[num]--;
                    if (connected[num] == 1 && num != 0) {
                        queue.add(num);
                        visited[num] = true;
                    }
                    continue outer;
                }
            }
        }
        if (result[0] == 0) return answer;
        else return -1;
    }
}