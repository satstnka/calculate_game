package jp.trans_it.game.calculate_game;

import org.junit.jupiter.api.Test;

class CalculateGameTest {

	@Test
	void testRandom() {
		for(int i = 0; i < 10; i++) {
			int number = CalculateGame.getRandomNumber();
			System.out.println(number);
		}
	}

	@Test
	void testCheckNumber() {
		String[] array = {"1", "123", "aaa", "c3po", "9z"};
		for(int i = 0; i < array.length; i++) {
			String string = array[i];
			boolean result = CalculateGame.checkNumber(string);
			System.out.println(string + " : " + result);
		}
	}
}
