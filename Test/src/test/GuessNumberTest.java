package test;

import junit.framework.Assert;
import main.guessNumber.GuessNumber;
import main.guessNumber.GuessNumberValidate;

import org.junit.Test;

public class GuessNumberTest {

	@Test
	public void should_true_when_randomNum_4digit() {
		GuessNumber guessNumber = new GuessNumber();
		Assert.assertTrue(GuessNumberValidate.isFourDigit(guessNumber
				.getRandomNum()));
	}

	@Test
	public void should_true_when_randomNum_noDup() {
		GuessNumber guessNumber = new GuessNumber();
		Assert.assertTrue(!GuessNumberValidate.isDup(guessNumber.getRandomNum()));
	}
	
	@Test
	public void should_win_when_in_all_match() {
		GuessNumber guessNumber = new GuessNumber();
		String in = guessNumber.getRandomNum();
		Assert.assertEquals(GuessNumber.ALL_MATCH,guessNumber.compare(in));
	}
	
	@Test
	public void should_0A0B_when_in_all_not_matched() {
		GuessNumber guessNumber = new GuessNumber();
		String rannum = guessNumber.getRandomNum();
		Assert.assertEquals("0A0B", guessNumber.compare(mockInput(rannum).substring(0,4)));
	}
	
	
	@Test
	public void should_0A4B_when_in_all_position_wrong() {
		GuessNumber guessNumber = new GuessNumber();
		String rannum = guessNumber.getRandomNum();
		String newStr=rannum.substring(1)+rannum.substring(0,1);
		Assert.assertEquals("0A4B", guessNumber.compare(newStr));
	}
	
	@Test
	public void should_1A0B_when_in_1_correct() {
		GuessNumber guessNumber = new GuessNumber();
		String rannum = guessNumber.getRandomNum();
		String in = rannum.substring(0,1)+mockInput(rannum).substring(0,3);
		Assert.assertEquals("1A0B", guessNumber.compare(in));
	}
	
	
	@Test
	public void should_1A1B_when_in_1_correct_1_position_wrong() {
		GuessNumber guessNumber = new GuessNumber();
		String rannum = guessNumber.getRandomNum();
		String in = rannum.substring(0,1)+mockInput(rannum).substring(0,2)+rannum.substring(1,2);
		Assert.assertEquals("1A1B", guessNumber.compare(in));
	}
	
	private String mockInput(String rannum) {
		String in = "0123456789";
		char[] chs = rannum.toCharArray();
		for(char ch : chs) {
			in = in.replace(ch+"", "");
		}
		return in;
	}
}
