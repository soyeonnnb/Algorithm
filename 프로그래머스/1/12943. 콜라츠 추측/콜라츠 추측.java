class Solution {
    public int solution(int n) {
        long num = n;
        for(int i=1;i<=501;i++) {
            if (num == 1) return i-1;
            if (num%2 == 0) num/=2;
            else {
                num *= 3;
                num += 1;
            }
        }
        
        return -1;
    }
}