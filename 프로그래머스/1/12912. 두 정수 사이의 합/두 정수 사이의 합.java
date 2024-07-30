class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if (b < a) {
            int t = a;
            a = b;
            b = t;
        }
        
        for(int i=a; i<=b; i++) answer += i;
        
        return answer;
    }
}