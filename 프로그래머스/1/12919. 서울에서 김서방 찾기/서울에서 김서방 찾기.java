class Solution {
    public String solution(String[] seoul) {
        
        int ans = 0;
        
        for(int i=0;i<seoul.length;i++) {
            if (seoul[i].equals("Kim")) {
                ans = i;
                break;
            }
        }
        return "김서방은 "+ans+"에 있다";
    }
}