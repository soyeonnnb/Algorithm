import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double total = 0;

        for(int tc=0;tc<20;tc++) {
            String name = sc.next();
            double credit = Double.parseDouble(sc.next());
            String gradeString = sc.next();
            if (gradeString.equals("P")) continue;
            double grade = 0.0;
            switch (gradeString) {
                case "A+" -> grade = 4.5;
                case "A0" -> grade = 4.0;
                case "B+" -> grade = 3.5;
                case "B0" -> grade = 3.0;
                case "C+" -> grade = 2.5;
                case "C0" -> grade = 2.0;
                case "D+" -> grade = 1.5;
                case "D0" -> grade = 1.0;
                case "F" -> grade = 0.0;
            }

            total += credit;
            sum += grade * credit;
        }


        System.out.printf("%f", sum / total);
    }
}