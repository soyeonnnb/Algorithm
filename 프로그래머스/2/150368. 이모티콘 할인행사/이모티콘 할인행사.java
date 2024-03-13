import java.util.Arrays;

class Solution {
    private static int[] answer, sales, prices;
    private static int N, M;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        N=users.length;
        M=emoticons.length;
        prices = new int[N];
        sales = new int[M];
        recur(0, users, emoticons);
        return answer;
    }
    private static void recur(int cur, int[][] users, int[] emoticons) {
        if (cur == M) {
            Arrays.fill(prices, 0);
            for(int m=0;m<M;m++) {
                int ePrice = emoticons[m] - emoticons[m] * sales[m] / 100;
                for(int i=0;i<N;i++) {
                    if (users[i][0] <= sales[m]) prices[i] += ePrice;
                }
            }
            int count = 0;
            int total = 0;
            for(int i=0;i<N;i++) {
                if (users[i][1] <= prices[i]) count++;
                else total += prices[i];
            }
            if (count > answer[0]) {
                answer[0] = count;
                answer[1] = total;
            } else if (count == answer[0]) {
                answer[1] = Math.max(answer[1], total);
            }
            return;
        }
        
        for(int i=10;i<=40;i+=10) {
            sales[cur] = i;
            recur(cur+1, users, emoticons);
        }
        
    }
}