import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Candidate implements Comparable<Candidate> {
        int skill, num;
        public Candidate(int skill, int num) {
            this.skill = skill;
            this.num = num;
        }


        @Override
        public int compareTo(Candidate o) {
            return o.skill - this.skill;
        }

//        @Override
//        public String toString() {
//            return "Candidate[num="+this.num+", skill="+this.skill+"]";
//        }
    }
    private static boolean[] checked;
    private static int answer;
    private static Candidate[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new Candidate[5][5];
        StringTokenizer st;
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[j][i] = new Candidate(n, i);
            }
        }
        checked = new boolean[N];
        answer=0;
        for(int i=0;i<5;i++) Arrays.sort(arr[i]);
        for(int i=5;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                int n = Integer.parseInt(st.nextToken());
                for(int k=0;k<5;k++) {
                    if (arr[j][k].skill < n) {
                        for(int l=4;l>=k+1;l--) arr[j][l] = arr[j][l-1];
                        arr[j][k] = new Candidate(n, i);
                        break;
                    }
                }
            }
        }
        recur(0, 0);
        System.out.println(answer);
    }
    private static void recur(int cur, int sum) {
        if (cur == 5) {
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=0;i<5;i++) {
            if (checked[arr[cur][i].num]) continue;
            checked[arr[cur][i].num] = true;
            recur(cur+1, sum + arr[cur][i].skill);
            checked[arr[cur][i].num] = false;
        }
    }
}