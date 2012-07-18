package test;

import junit.framework.Assert;
import main.guessNumber.GenerateAnswer;

import org.junit.Test;

public class GenerateAnswerTest {

	@Test
	public void should_true_when_randomNum_4digit() {
		GenerateAnswer generateAnswer = new MockGenerateAnswer(new Integer[] {1,2,3,4});
		Assert.assertEquals("1234", generateAnswer.generateRadom());
	}
	
	@Test
	public void should_true_when_randomNum_4digit_have_dup() {
		GenerateAnswer generateAnswer = new MockGenerateAnswer(new Integer[] {1,1,1,1,1,1,3,4,5});
		Assert.assertEquals("1345", generateAnswer.generateRadom());
	}

}
