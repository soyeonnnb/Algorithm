class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wm = 0;
        int hm = 0;
        for(int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            wm = Math.max(wm, size[0]);
            hm = Math.max(hm, size[1]);
        }
        return wm * hm;
    }
}