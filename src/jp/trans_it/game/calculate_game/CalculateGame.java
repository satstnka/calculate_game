package jp.trans_it.game.calculate_game;

import java.util.Random;
import java.util.Scanner;

public class CalculateGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("開始します。Enterキーを押してください。");
		scanner.nextLine();
		start(scanner);

		scanner.close();
	}


	/**
	 * 数当てゲームを開始する。
	 */
	private static void start(Scanner scanner) {
		int time = 0;
		int correct = 0;

		for(int i = 0; i < 10; i++) {
			int a = getRandomNumber();
			int b = getRandomNumber();
			int answer = a + b;

			System.out.println(a + " + " + b + " = ");

			long startTime = System.currentTimeMillis();

			String line = scanner.nextLine();

			if(checkNumber(line)) {
				int number = Integer.parseInt(line);

				if(number == answer) {
					correct++;
					System.out.println("〇 正解!!! (^o^)");
				}
				else {
					System.out.println("× 不正解。(T_T)");
				}
			}
			else {
				System.out.println("数字を入れてください。");
			}

			long endTime = System.currentTimeMillis();
			time = time + (int)(endTime - startTime);
		}

		double second = (double)time / 1000.0;
		showResult(second, correct);
	}


	public static int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(9) + 1;
		return number;
	}


	public static boolean checkNumber(String line) {
		boolean result = true;
		if(line.length() > 0) {
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(!Character.isDigit(c)) {
					result = false;
				}
			}
		}
		else {
			result = false;
		}
		return result;
	}

	/**
	 * タイムと正解数の結果と、そこから導き出される脳年齢を表示する。
	 * @param second タイム (秒)
	 * @param correct 正解数
	 */
	public static void showResult(double second, int correct) {
		double normalizedTime = second + 3.0 * (double)(10 - correct);
		String age = "";
		if(normalizedTime < 10.0) {
			age = "10代";
		}
		else if(normalizedTime < 13.0) {
			age = "20代";
		}
		else if(normalizedTime < 16.0) {
			age = "30代";
		}
		else if(normalizedTime < 19.0) {
			age = "40代";
		}
		else if(normalizedTime < 21.0) {
			age = "50代";
		}
		else {
			age = "60代以上";
		}

		System.out.println("正解数: " + correct);
		System.out.println("タイム: " + second);
		System.out.println("あなたの脳年齢は" + age + "です。");
	}
}


