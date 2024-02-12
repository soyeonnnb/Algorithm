import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] width = new int[1000010];
        int[] height = new int[1000010];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken())+500000;
        int y = Integer.parseInt(st.nextToken())+500000;
        int[] init = new int[]{x, y};
        int xi = 0;
        int yi = 0;
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            xi = Integer.parseInt(st.nextToken())+500000;
            yi = Integer.parseInt(st.nextToken())+500000;
            if (x == xi) {
                if (y < yi) {
                    height[y]++;
                    height[yi]--;
                } else {
                    height[yi]++;
                    height[y]--;
                }
                y = yi;
            } else { // (y == yi)
                if (x < xi) {
                    width[x]++;
                    width[xi]--;
                } else {
                    width[xi]++;
                    width[x]--;
                }
                x = xi;
            }
        }
        xi = init[0];
        yi = init[1];
        if (x == xi) {
            if (y < yi) {
                height[y]++;
                height[yi]--;
            } else {
                height[yi]++;
                height[y]--;
            }
        } else { // (y == yi)
            if (x < xi) {
                width[x]++;
                width[xi]--;
            } else {
                width[xi]++;
                width[x]--;
            }
        }
        for(int i=1;i<=1000000;i++) {
            height[i] += height[i-1];
            width[i] += width[i-1];
        }
        int answer = 0;
        for(int i=0;i<=1000000;i++) {
            answer = Math.max(answer, width[i]);
            answer = Math.max(answer, height[i]);
        }
        System.out.println(answer);

    }
}