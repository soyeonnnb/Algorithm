// 16:20 ~
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);
        int[] s = new int[data.length];
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data[i].length;j++) {
                s[i] += data[i][j] % (i+1);
            }
        }
        // System.out.println(Arrays.toString(s));
        int ans = s[row_begin-1];
        for(int i=row_begin;i<row_end;i++) {
            ans = ans^s[i];
        }
        
        return ans;
    }
    
    
}