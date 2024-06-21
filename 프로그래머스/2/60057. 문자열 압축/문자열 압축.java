class Solution {
    public int solution(String s) {
        int N = s.length(); // N개로 자름
        int answer = N;
        for(int n=1;n<=N;n++) {
            int result = 0;
            for(int i=0;i<N;) { // 시작점
                if (i+n > N) {
                    result += N-i;
                    break;
                }
                String nowStr = s.substring(i, i+n);
                
                int count = 1; // 현재 i ~ i+n 까지의 문자열과 같은 건 하나밖에 없음
                i += n;
                while(i + n <= N && nowStr.equals(s.substring(i, i+n))) {
                    count++;
                    i += n;
                }
                // System.out.println(n+" "+nowStr+" "+count);
                if (count == 1) {
                    result += n;
                } else{
                    result += n;
                    if (count < 10) result += 1;
                    else if (count < 100) result += 2;
                    else if (count < 1000) result += 3;
                    else if (count == 1000) result += 4;
                }
            }
            // System.out.println("zzzzzzzzzzz"+n+" "+result);
            answer = Math.min(result, answer);
            
        }
        
        return answer;
    }
}