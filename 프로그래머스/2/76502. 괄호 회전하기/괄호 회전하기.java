import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int N=s.length(); // s의 문자열 길이
        Stack<Character> stack = new Stack<>();
        outer: for(int x=0;x<N;x++) { // x 만큼 회전 == x 인덱스가 첫 시발점
            stack.clear();
            int idx = x;
            for(int t = 0; t<N ; t++) { // 총 N만큼만 움직이니까 걍 for 문을 통해 반복
                if (stack.isEmpty() || s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{') {
                    stack.push(s.charAt(idx));
                }
                else if (s.charAt(idx) == ')' && stack.peek() == '(' || s.charAt(idx) == ']' && stack.peek() == '[' || s.charAt(idx) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else continue outer;
                
               idx = (idx+1)%N;
                
            }
            if (stack.isEmpty()) answer++;
            
        }
        return answer;
    }
}