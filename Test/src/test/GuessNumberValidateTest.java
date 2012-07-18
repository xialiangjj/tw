package test;

import junit.framework.Assert;
import main.guessNumber.GuessNumberValidate;

import org.junit.Test;

public class GuessNumberValidateTest {
	
	@Test
	public void should_false_when_input_not_digit(){
		String in="123r";
		Assert.assertFalse(GuessNumberValidate.isFourDigit(in));
	}
	@Test
	public void should_false_when_input_less_4(){
		String in="123";
		Assert.assertFalse(GuessNumberValidate.isFourDigit(in));
	}
	
	@Test
	public void should_false_when_input_beyond_4(){
		String in="12345";
		Assert.assertFalse(GuessNumberValidate.isFourDigit(in));		
	}
	
	@Test
	public void should_true_when_input_is_digit(){
		String in="0234";
		Assert.assertTrue(GuessNumberValidate.isFourDigit(in));
	}
	
	@Test
	public void should_false_when_input_not_dup(){
		String in="1234";
		Assert.assertFalse(GuessNumberValidate.isDup(in));
	}
	
	@Test
	public void should_true_when_input_dup(){
		String in="2233";
		Assert.assertTrue(GuessNumberValidate.isDup(in));
	}
	
}
