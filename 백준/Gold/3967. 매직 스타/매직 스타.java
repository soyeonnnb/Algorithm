import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] arr;
    private static boolean[] visited;
    private static boolean fin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr =new int[12];
        int index=0;
        visited = new boolean[13];
        fin = false;
        for(int i=0;i<5;i++) {
            String str = br.readLine();
            for(int j=0;j<9;j++) if (str.charAt(j) != '.') {
                if (str.charAt(j) == 'x') {
                    index++;
                } else{
                    arr[index++] = str.charAt(j)-'A'+1;
                    visited[str.charAt(j)-'A'+1]=true;
                }
            }
        }
        recur(0);
    }

    private static boolean checked() {
        if (arr[0] + arr[2]+ arr[5] + arr[7] != 26) return false;
        else if (arr[0] + arr[3] + arr[6] + arr[10] != 26) return false;
        else if (arr[1] + arr[2] + arr[3] + arr[4] != 26) return false;
        else if (arr[1] + arr[5] + arr[8] + arr[11] != 26) return false;
        else if (arr[4] + arr[6] + arr[9] + arr[11] != 26) return false;
        else if (arr[7] + arr[8] + arr[9] + arr[10] != 26) return false;
        return true;
    }
    private static char toChar(int num) {
        return (char)(num+'A'-1);
    }

    private static boolean checkRow(int cur) {
        if ((cur == 0 || cur == 2 || cur == 5 || cur == 7) && arr[0] + arr[2]+ arr[5] + arr[7] > 26) return false;
        else if ((cur == 0 || cur == 3 || cur == 6 || cur == 10) && arr[0] + arr[3] + arr[6] + arr[10] > 26) return false;
        else if ((cur == 1 || cur == 2 || cur == 3 || cur == 4) && arr[1] + arr[2] + arr[3] + arr[4] > 26) return false;
        else if ((cur == 1 || cur == 5 || cur == 8 || cur == 11) && arr[1] + arr[5] + arr[8] + arr[11] > 26) return false;
        else if ((cur == 4 || cur == 6 || cur == 9 || cur == 11) && arr[4] + arr[6] + arr[9] + arr[11] > 26) return false;
        else if ((cur == 7 || cur == 8 || cur == 9 || cur == 10) && arr[7] + arr[8] + arr[9] + arr[10] > 26) return false;
        return true;
    }

    private static void recur(int cur) {
        if (fin) return;
        if (cur == 12) {
            if (checked()) {
                System.out.println("...."+toChar(arr[0])+"....");
                System.out.println("."+toChar(arr[1])+"."+toChar(arr[2])+"."+toChar(arr[3])+"."+toChar(arr[4])+".");
                System.out.println(".."+toChar(arr[5])+"..."+toChar(arr[6])+"..");
                System.out.println("."+toChar(arr[7])+"."+toChar(arr[8])+"."+toChar(arr[9])+"."+toChar(arr[10])+".");
                System.out.println("...."+toChar(arr[11])+"....");
                fin = true;
            }
            return;
        } else if (cur >= 1) {
            if (!checkRow(cur-1)) return;
        }
        if (arr[cur] != 0) recur(cur+1);
        else {
            for(int i=1;i<=12;i++) {
                if(visited[i]) continue;
                visited[i] = true;
                arr[cur] = i;
                recur(cur+1);
                visited[i] = false;
            }
            arr[cur] = 0;
        }
    }
}