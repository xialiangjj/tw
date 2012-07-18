package test;

import main.guessNumber.Generate4DigitAnswer;

public class MockGenerateAnswer extends Generate4DigitAnswer{
	
	private Integer[]  mockRandomNums;
	
	private int index=0;

	public MockGenerateAnswer(Integer[] integers) {
		mockRandomNums = integers;
	}

	protected int getRandomNumber(){
		return mockRandomNums[index++];
	}

}
