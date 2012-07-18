package main.guessNumber;

import java.util.Scanner;

public class GuessNumber {
	
	public static final String ALL_MATCH="win!";
	
	static final String GAME_OVER="game over!";
	
	static final String CORRECT="A";
	
	static final String POSITION_ERROR="B";
	
	private String randomnum;
	
	public GuessNumber(){
		Generate4DigitAnswer answer = new Generate4DigitAnswer();
		randomnum = answer.generateRadom();
	}
	
	public String getRandomNum() {
		return randomnum;
	}
	
	
	public String  compare(String in){
		int acount=0;
		int bcount=0;
		if(randomnum.equals(in))
			return ALL_MATCH;
		for(char ch:in.toCharArray()){
			if(randomnum.contains(ch+"")  ){
				if(randomnum.indexOf(ch)==in.indexOf(ch))
					acount++;
				else bcount++;
			}
		}
		return  acount+CORRECT+bcount+POSITION_ERROR;	
		
	}
	
	public String validate(String in) {
		if(!GuessNumberValidate.isFourDigit(in)) {
			return "请输入4个0-9的数字！";
		}
		if(GuessNumberValidate.isDup(in)){
			return "请输入不重复的数字！";
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		System.out.println("××××××××××××××××××××××××××××××××××××××××××××××××猜数游戏开始×××××××××××××××××××××××××××××××××××××××××××××××××××××");
		System.out.println("规则：输入0-9之间的4个不重复的数字，如果与系统产生的数字完全匹配（包括数字顺序）即赢得本次游戏！一次游戏6次机会！");
		System.out.println("结果 : A表示数字与顺序都匹配  B表示数字匹配但是位置不对。如1A1B表示有一个数字完全匹配，有一个数字是数字匹配！");
		System.out.println("例如 : 系统随机产生的数字是1234，如果输入7894，则结果为1A0B！");
		System.out.println("请输入：");
		Scanner scanner=new Scanner(System.in);
		GuessNumber game = new GuessNumber();
		String in = scanner.nextLine();
		String result = game.validate(in);
		if(result != null) {
			System.out.println(game.validate(in));
		}else {
			System.out.println(game.compare(in));
		}
	}


}
