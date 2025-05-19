
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nowY = Integer.parseInt(st.nextToken());
        int nowM = Integer.parseInt(st.nextToken());
        int nowD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nextY = Integer.parseInt(st.nextToken());
        int nextM = Integer.parseInt(st.nextToken());
        int nextD = Integer.parseInt(st.nextToken());

        LocalDate nowDate = LocalDate.of(nowY, nowM, nowD);
        LocalDate nextDate = LocalDate.of(nextY, nextM, nextD);

        if (LocalDate.of(nowY+1000, nowM, nowD).isEqual(nextDate) || LocalDate.of(nowY+1000, nowM, nowD).isBefore(nextDate)) {
            System.out.println("gg");
            return;
        }
        int count = 0;
        while(!nowDate.isEqual(nextDate)) {
            count++;
            nowDate = nowDate.plusDays(1L);
        }
        System.out.println("D-"+count);
    }
}
