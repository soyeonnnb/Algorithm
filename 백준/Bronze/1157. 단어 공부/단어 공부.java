import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> str = Arrays.asList(sc.nextLine().trim().split(""));
		int[] numStrArray = new int[26];
		for (String el : str) {
			int strNum = (int) el.charAt(0);
			if (strNum >= 97)
				strNum -= 32;
			strNum -= 65;
			numStrArray[strNum] += 1;
		}
		int answerIndex = 0;
		int answerCount = 0;
		boolean isSame = false;
		for (int i = 0; i < 26; i++) {
			if (numStrArray[i] > answerCount) {
				answerIndex = i;
				answerCount = numStrArray[i];
				isSame = false;
			} else if (numStrArray[i] == answerCount) {
				isSame = true;
			}
		}
		if (isSame)
			System.out.println("?");
		else
			System.out.println((char)(answerIndex+65));
		sc.close();
	}
}