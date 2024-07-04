import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] arr;
    private static int[][] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parent = new int[N][2];
        for(int i=0;i<N;i++) {
            parent[i][0] = i; // 몇번 부모에 속하는지
            parent[i][1] = 1; // 해당 부모의 개수
        }
        arr = new int[N][2][2];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) for(int k=0;k<2;k++) arr[i][j][k] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if (cross(i, j)) union(i, j);
            }
        }

        int count = 0;
        int max = 0;
        for(int i=0;i<N;i++) {
            if(parent[i][0] != i) continue;
            count++;
            max = Math.max(max, parent[i][1]);
        }
        System.out.println(count+"\n"+max);
    }

    private static boolean cross(int x, int y) {
        int[] arr1 = arr[x][0];
        int[] arr2 = arr[x][1];
        int[] arr3 = arr[y][0];
        int[] arr4 = arr[y][1];

        int p1p2 = cww(arr1, arr2, arr3) * cww(arr1, arr2, arr4);
        int p3p4 = cww(arr3, arr4, arr1) * cww(arr3, arr4, arr2);

        if (p1p2 == 0 && p3p4 == 0) {
            if (Math.max(arr1[0], arr2[0]) < Math.min(arr3[0], arr4[0])) return false;
            else if (Math.max(arr1[1], arr2[1]) < Math.min(arr3[1], arr4[1])) return false;
            else if (Math.max(arr3[0], arr4[0]) < Math.min(arr1[0], arr2[0])) return false;
            else if (Math.max(arr3[1], arr4[1]) < Math.min(arr1[1], arr2[1])) return false;
            else return true;
        } else if (p1p2 <= 0 && p3p4 <= 0) return true;
        else return false;
    }

    private static int cww(int[] arr1, int[] arr2, int[] arr3) {
        int s = arr1[0]*arr2[1] + arr2[0]*arr3[1] + arr3[0]*arr1[1];
        s -= (arr1[1]*arr2[0] + arr2[1]*arr3[0] + arr3[1] * arr1[0]);

        if (s < 0) return -1;
        else if (s > 0) return 1;
        else return 0;
    }


    private static int findset(int x) {
        if (parent[x][0] == x) return x;
        else return parent[x][0] = findset(parent[x][0]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;

        parent[yr][0] = xr;
        parent[xr][1] += parent[yr][1];
        return true;
    }
}