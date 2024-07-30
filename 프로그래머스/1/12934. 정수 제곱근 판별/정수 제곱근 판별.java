class Solution {
    public long solution(long n) {
        long answer = 0;
        long num = 1;
        while(num * num <= n) {
            if (num * num == n) {
                return (num+1) * (num+1);
            }
            num++;
        }
        return -1;
    }
}