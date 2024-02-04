import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Animal {
        int x;
        int y;
        boolean checked;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
            this.checked = false;
        }

//        @Override
//        public String toString() {
//            return "Animal[x="+x+", y="+y+", checked="+checked+"]";
//        }

        @Override
        public String toString() {
            return "["+x+", "+y+"]";
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[] marr =new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) marr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(marr);
//        System.out.println(Arrays.toString(marr));
        Animal[] arr = new Animal[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Animal(x, y);
        }
        Arrays.sort(arr, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);
        int answer = 0;
        // 각각의 사대를 확인
        for(int m=0;m<M;m++) {
            for(int flag = -L;flag <= L;flag++) { // i가 x좌표가 됨
                int i = marr[m] + flag;
                int s = 0;
                int e = N-1;
                int xl = -1; // x_lower_bound
                int xr = -1; // x_upper_bound
                int yl = -1; // y_lower_bound
                int yr = -1; // y_upper_bound
                while(s<=e) {
                    int mid = (s+e)/2;
                    if (arr[mid].x < i) {
                        s = mid+1;
                    } else {
                        e = mid-1;
                        xl = mid;
                    }
                }
                s = 0;
                e = N-1;
                while(s<=e) {
                    int mid = (s+e)/2;
                    if (arr[mid].x <= i) {
                        xr = mid;
                        s = mid+1;
                    } else {
                        e = mid-1;
                    }
                }
                if (xl == -1 || xr == -1) continue;
                s = xl;
                e = xr;
                int go = L - Math.abs(flag);
                while(s<=e) {
                    int mid = (s+e)/2;
                    if (arr[mid].y < -go) {
                        s = mid+1;
                    } else {
                        e = mid-1;
                        yl = mid;
                    }
                }

                s = xl;
                e = xr;
                while(s<=e) {
                    int mid = (s+e)/2;
                    if (arr[mid].y <= go) {
                        yr = mid;
                        s = mid+1;
                    } else {
                        e = mid-1;
                    }
                }
                if (yl == -1 || yr == -1) continue;
//                System.out.println(i+" "+xl+" "+xr+"  ->   "+yl+" "+yr);
                for(int j=yl;j<=yr;j++) {

                    if (!arr[j].checked) {
//                        System.out.println(arr[j]);
                        answer++;
                        arr[j].checked = true;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(answer);
    }
}